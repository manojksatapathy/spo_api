package com.ibm.spo.api;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import com.ibm.spo.databuilder.ScenarioBuilder;
import com.ibm.spo.model.Scenario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;

@Path("/scenario")

@Api(description = "the scenario API")


@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2019-11-25T14:54:20.504+05:30")


public class ScenarioApi  {

    @POST
    
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/xml", "application/json" })
    @ApiOperation(value = "Add a new scenario to the system", notes = "", response = void.class, authorizations = {
        @Authorization(value = "scenariostore_auth", scopes = {
            @AuthorizationScope(scope = "read:scenarios", description = "read your scenarios"),
            @AuthorizationScope(scope = "write:scenarios", description = "modify scenarios in your account")
        })
    }, tags={ "scenario",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 405, message = "Invalid input", response = void.class) })
    public Response addScenario(Scenario body) {
    	return Response.ok().entity("magic!").build();
    }

    @DELETE
    @Path("/{scenarioId}")
    
    @Produces({ "application/xml", "application/json" })
    @ApiOperation(value = "Deletes a scenario", notes = "", response = void.class, authorizations = {
        @Authorization(value = "scenariostore_auth", scopes = {
            @AuthorizationScope(scope = "read:scenarios", description = "read your scenarios"),
            @AuthorizationScope(scope = "write:scenarios", description = "modify scenarios in your account")
        })
    }, tags={ "scenario",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied", response = void.class),
        @ApiResponse(code = 404, message = "Scenario not found", response = void.class) })
    public Response deleteScenario(@PathParam("scenarioId") @ApiParam("Scenario id to delete") Long scenarioId,@HeaderParam("api_key") String apiKey) {
    	return Response.ok().entity("magic!").build();
    }

    @GET
    @Path("/all")
    
    @Produces({ "application/xml", "application/json" })
    @ApiOperation(value = "Finds all Scenarios", notes = "return all scenarios", response = Scenario.class, responseContainer = "List", authorizations = {
        @Authorization(value = "scenariostore_auth", scopes = {
            @AuthorizationScope(scope = "read:scenarios", description = "read your scenarios"),
            @AuthorizationScope(scope = "write:scenarios", description = "modify scenarios in your account")
        })
    }, tags={ "scenario",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Scenario.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Invalid status value", response = Scenario.class, responseContainer = "List") })
    public Response findAllScenarios() {
    	List<Scenario> scenarios = ScenarioBuilder.getScenarios();
    	GenericEntity<List<Scenario>> genericEntity = new GenericEntity<List<Scenario>>(scenarios){};
    	System.out.println(genericEntity);
    	return Response.ok(genericEntity, "application/json").build();
    }

    @GET
    @Path("/findByStatus")
    
    @Produces({ "application/xml", "application/json" })
    @ApiOperation(value = "Finds Scenarios by status", notes = "Multiple status values can be provided with comma separated strings", response = Scenario.class, responseContainer = "List", authorizations = {
        @Authorization(value = "scenariostore_auth", scopes = {
            @AuthorizationScope(scope = "read:scenarios", description = "read your scenarios"),
            @AuthorizationScope(scope = "write:scenarios", description = "modify scenarios in your account")
        })
    }, tags={ "scenario",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Scenario.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Invalid status value", response = Scenario.class, responseContainer = "List") })
    public Response findScenariosByStatus(@QueryParam("status") @NotNull  List<String> status) {
    	return Response.ok().entity("magic!").build();
    }

    @GET
    @Path("/findByTags")
    
    @Produces({ "application/xml", "application/json" })
    @ApiOperation(value = "Finds Scenarios by tags", notes = "Muliple tags can be provided with comma separated strings. Use         tag1, tag2, tag3 for testing.", response = Scenario.class, responseContainer = "List", authorizations = {
        @Authorization(value = "scenariostore_auth", scopes = {
            @AuthorizationScope(scope = "read:scenarios", description = "read your scenarios"),
            @AuthorizationScope(scope = "write:scenarios", description = "modify scenarios in your account")
        })
    }, tags={ "scenario",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Scenario.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Invalid tag value", response = Scenario.class, responseContainer = "List") })
    public Response findScenariosByTags(@QueryParam("tags") @NotNull  List<String> tags) {
    	return Response.ok().entity("magic!").build();
    }

    @GET
    @Path("/{scenarioId}")
    
    @Produces({ "application/xml", "application/json" })
    @ApiOperation(value = "Find scenario by ID", notes = "Returns a single scenario", response = Scenario.class, authorizations = {
        @Authorization(value = "api_key")
    }, tags={ "scenario",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Scenario.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied", response = Scenario.class),
        @ApiResponse(code = 404, message = "Scenario not found", response = Scenario.class) })
    public Response getScenarioById(@PathParam("scenarioId") @ApiParam("ID of scenario to return") Long scenarioId) {
    	return Response.ok().entity("magic!").build();
    }

    @PUT
    
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/xml", "application/json" })
    @ApiOperation(value = "Update an existing scenario", notes = "", response = void.class, authorizations = {
        @Authorization(value = "scenariostore_auth", scopes = {
            @AuthorizationScope(scope = "read:scenarios", description = "read your scenarios"),
            @AuthorizationScope(scope = "write:scenarios", description = "modify scenarios in your account")
        })
    }, tags={ "scenario",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied", response = void.class),
        @ApiResponse(code = 404, message = "Scenario not found", response = void.class),
        @ApiResponse(code = 405, message = "Validation exception", response = void.class) })
    public Response updateScenario(Scenario body) {
    	return Response.ok().entity("magic!").build();
    }

    @POST
    @Path("/{scenarioId}")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/xml", "application/json" })
    @ApiOperation(value = "Updates a scenario in the store with form data", notes = "", response = void.class, authorizations = {
        @Authorization(value = "scenariostore_auth", scopes = {
            @AuthorizationScope(scope = "read:scenarios", description = "read your scenarios"),
            @AuthorizationScope(scope = "write:scenarios", description = "modify scenarios in your account")
        })
    }, tags={ "scenario" })
    @ApiResponses(value = { 
        @ApiResponse(code = 405, message = "Invalid input", response = void.class) })
    public Response updateScenarioWithForm(@PathParam("scenarioId") @ApiParam("ID of scenario that needs to be updated") Long scenarioId,@FormParam(value = "name")  String name,@FormParam(value = "status")  String status) {
    	return Response.ok().entity("magic!").build();
    }
}

