package com.ibm.spo;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.io.IOUtils;

import com.atlassian.oai.validator.OpenApiInteractionValidator;
import com.atlassian.oai.validator.interaction.request.CustomRequestValidator;
import com.atlassian.oai.validator.model.ApiOperation;
import com.atlassian.oai.validator.model.Request;
import com.atlassian.oai.validator.model.SimpleRequest;
import com.atlassian.oai.validator.report.ValidationReport;
//import com.ibm.apm.db.MultiTenantManager;
import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;
import com.ibm.json.java.OrderedJSONObject;
import com.ibm.websphere.security.auth.WSSubject;

/**
 * Servlet Filter implementation class ParameterFilter
 */
@WebFilter("/*")
public class RestValidation implements Filter {
	
	private static final Logger logger = Logger.getLogger(RestValidation.class.getName());
	
	private OpenApiInteractionValidator validator;
	
	private JSONObject swaggerDoc;

    /**
     * Default constructor. 
     */
    public RestValidation() {
    	
    }
    
    /**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		try(InputStream input = fConfig.getServletContext().getResourceAsStream("META-INF/swagger.json")){
			swaggerDoc = OrderedJSONObject.parse(input);
			validator = OpenApiInteractionValidator.createFor(swaggerDoc.toString()).withCustomRequestValidation(new AuthValidator()).build();
			logger.log(Level.INFO, "Swagger validator created.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
//		logger.log(Level.INFO, "Request URL: " + req.getRequestURL());
//		logger.log(Level.INFO, "Request Time: " + new Timestamp(new Date().getTime()));
//		logger.log(Level.INFO, "Request Method: " + req.getMethod());
//		logger.log(Level.INFO, "Request User: " + req.getRemoteUser());
//		logger.log(Level.INFO, "Request Tenant ID: " + MultiTenantManager.getTenantId());
		
		
		req = new MethodOverrideWrapper(req);
		HttpServletResponse resp = (HttpServletResponse)response; 
		
		//serve swagger.json
		if(req.getPathInfo().equals("/swagger.json")) {
			resp.setContentType("application/json");
			
			JSONObject swaggerDocClone = (JSONObject)swaggerDoc.clone();
			JSONArray schemas = new JSONArray();
			if(req.isSecure()) {
				schemas.add("https");
			} else {
				schemas.add("http");
			}
			
			String host = req.getRequestURL().toString().split("/")[2];
			swaggerDocClone.put("schemes", schemas);
			swaggerDocClone.put("host", host);
			
			swaggerDocClone.serialize(resp.getWriter());
			return;
		}
		
		//serve swagger UI
		String pathInfo = req.getPathInfo();
		
		if(pathInfo.equals("/")) {
			this.responseFile(req, resp, "/index.html", "text/html");
			return;
		}
		
		if(pathInfo.equals("/swagger-ui-bundle.js") || pathInfo.equals("/swagger-ui-standalone-preset.js")) {
			this.responseFile(req, resp, pathInfo, "application/x-javascript");
			return;
		}
		
		if(pathInfo.equals("/swagger-ui.css")) {
			this.responseFile(req, resp, pathInfo, "text/css");
			return;
		}
		
		//check if user authenticated
//		if(WSSubject.getCallerPrincipal() == null) {
//			JSONObject jsonObject = new JSONObject();
//			jsonObject.put("status", Status.UNAUTHORIZED.getStatusCode());
//			
//			JSONArray err = new JSONArray();
//			err.add(Status.UNAUTHORIZED.getReasonPhrase());
//			jsonObject.put("message", err);
//			
//			resp.setStatus(Status.UNAUTHORIZED.getStatusCode());
//			resp.setHeader("Content-Type", MediaType.APPLICATION_JSON);
//			resp.getWriter().write(jsonObject.toString());
//
//			return;
//		}
		
		//TODO: user req.getQueryString to build
		String queryString = req.getQueryString();
		Map<String, ArrayList<String>> parameterMap = new HashMap<String, ArrayList<String>>();
		
		if(queryString != null && !queryString.isEmpty()) {
			String[] nameValuePairs = queryString.split("&");
			for(String nameValuePair : nameValuePairs) {
				String[] splitedNameValuePair = nameValuePair.split("=", 2);
				if(splitedNameValuePair.length > 1) {
					String name = splitedNameValuePair[0];
					String value = splitedNameValuePair[1];
					
					String[] splitedValue = value.split(",");
					
					if(parameterMap.get(name) == null) {
						parameterMap.put(name, new ArrayList<String>());
					}
					parameterMap.get(name).addAll(Arrays.asList(splitedValue));
				}
			}
		}
		
		
		
		SimpleRequest.Builder builder = new SimpleRequest.Builder(req.getMethod(), req.getRequestURI(), true);
		for(String key : parameterMap.keySet()) {
			builder.withQueryParam(key, parameterMap.get(key).toArray(new String[] {}));
		}
		
		if (req.getMethod() != "GET") {
			builder.withBody("[]");
		}
		
		ValidationReport report = this.validator.validateRequest(builder.build());
		
		//check auth failure;
//		if( report.getMessages().parallelStream().filter(msg -> msg.getKey().equals("Auth Fail")).count() > 0) {
//			JSONObject jsonObject = new JSONObject();
//			jsonObject.put("status", Status.FORBIDDEN.getStatusCode());
//			JSONArray err = new JSONArray();
//			err.add(Status.FORBIDDEN.getReasonPhrase());
//			jsonObject.put("message", err);
//			
//			resp.setStatus(Status.FORBIDDEN.getStatusCode());
//			resp.setHeader("Content-Type", MediaType.APPLICATION_JSON);
//			resp.getWriter().write(jsonObject.toString());
//			logger.log(Level.INFO, "Request Auth fail: " + Status.FORBIDDEN.getStatusCode());
//			return;
//		};
		
		
		//check request format errors
//		List<String> errors = report.getMessages().stream().filter(msg -> msg.getLevel() == ValidationReport.Level.ERROR).map(msg -> msg.getMessage()).collect(Collectors.toList());
//		JSONArray error = new JSONArray();
//		
//		errors.remove("No request body is expected but one was found.");
//		
//		error.addAll(errors);
//		
//		if(!errors.isEmpty()) {
//			JSONObject jsonObject = new JSONObject();
//			jsonObject.put("status", Status.BAD_REQUEST.getStatusCode());
//			JSONArray err = new JSONArray();
//			err.addAll(errors);
//			jsonObject.put("message", err);
//			
//			resp.setStatus(Status.BAD_REQUEST.getStatusCode());
//			resp.setHeader("Content-Type", MediaType.APPLICATION_JSON);
//			resp.getWriter().write(jsonObject.toString());
//			logger.log(Level.INFO, "Request Bad Request: " + Status.BAD_REQUEST.getStatusCode());
//			return;
//		} 
		
		//rewrite parameters to support comma separated parameters
		chain.doFilter(new DecodeCSVWraper(req), response);
		
		
	}
	
	
	/**
	 * 
	 * An validator that check 
	 * 1, if user had authenticated
	 * 2, if user's role authorized to access the service  
	 * 
	 * need ensure x-rolesAllowed appear in swagger.json
	 *
	 */
	class AuthValidator implements CustomRequestValidator {

		@Override
		public ValidationReport validate(Request request, ApiOperation apiOperation) {
			
			ValidationReport.Message authFailMsg = ValidationReport.Message.create("Auth Fail", "Not Authorized").build();
			ValidationReport authFailReport = ValidationReport.from(authFailMsg);
			
			Map<String, Object> extensions = apiOperation.getOperation().getExtensions();
			if(extensions == null || extensions.isEmpty() || extensions.get("x-rolesAllowed") == null || !(extensions.get("x-rolesAllowed") instanceof List)) {
				//not define x-rolesAllowed
				return authFailReport;
			}
			
			@SuppressWarnings("unchecked")
			List<String> rolesAllowed = (List<String>)extensions.get("x-rolesAllowed");
//			List<String> userRoles = MultiTenantManager.getGroups();
			
//			if(userRoles.isEmpty()) {
//				//user do not have role, means not login
//				return authFailReport;
//			}
//			
//			
//			if(Collections.disjoint(rolesAllowed, userRoles)) {
//				//if there is no user roles in roles allowed
//				return authFailReport;
//			}
			
			return ValidationReport.empty();
		}
		
	}
	
	
	/**
	 * 
	 * jax-rs do not support csv format query parameters
	 * e.g. name=name1,name2
	 * this class convert name=name1,name2 to name=name1&name=name2
	 * that supported by jax-rs
	 * 
	 */
	class DecodeCSVWraper extends HttpServletRequestWrapper {
		
		String modifyedQueryString = null;
		
		
		public DecodeCSVWraper(HttpServletRequest request) throws IOException {
			super(request);
			
			
			String queryString = request.getQueryString();
			
			StringJoiner sj = new StringJoiner("&");
			
			if(queryString != null && !queryString.isEmpty()) {
				String[] parts = queryString.split("&");
				for(String part : parts) {
					String[] nameValue = part.split("=", 2);
					if(nameValue.length == 2) {
						String name = nameValue[0];
						String commaSplitedValues = nameValue[1];
						String[] values = commaSplitedValues.split(",");
						for(String value : values) {
							sj.add(name + "=" + value);
						}
					}
				}
			}
			modifyedQueryString = sj.toString();
			
			
		}
		
		@Override
		public String getQueryString() {
			return this.modifyedQueryString;
		}

	}
	
	
	class MethodOverrideWrapper extends HttpServletRequestWrapper {
		
		String queryString = null;
		
		String overrideMethod = null;
		
		public MethodOverrideWrapper(HttpServletRequest request) throws IOException {
			super(request);
			
			
			
			//check x-http-method-overwrite
			if("GET".equals(request.getHeader("X-HTTP-Method-Override")) && request.getMethod().equals("POST") && request.getContentType().equals("application/x-www-form-urlencoded") ) {
				this.overrideMethod = "GET";
				
				StringWriter writer = new StringWriter();
				IOUtils.copy(request.getInputStream(), writer, "UTF-8");
				queryString = writer.toString();
			}
			
		}
		
		@Override
		public String getQueryString() {
			if(queryString != null) {
				return this.queryString;
			}
			return super.getQueryString();
		}

		@Override
		public String getMethod() {
			if(overrideMethod != null) {
				return this.overrideMethod;
			}
			return super.getMethod();
		}
		
	}
	
	private void responseFile(HttpServletRequest req, HttpServletResponse resp, String file, String contentType) {
		
		try(InputStream input = req.getServletContext().getResourceAsStream(file)){
			resp.setHeader("Content-Type", contentType);
			IOUtils.copy(input, resp.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
