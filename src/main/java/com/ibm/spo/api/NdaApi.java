package com.ibm.spo.api;

import com.ibm.spo.databuilder.NdaBuilder;
import com.ibm.spo.databuilder.ScenarioBuilder;
import com.ibm.spo.model.NDA;
import com.ibm.spo.model.Scenario;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import io.swagger.annotations.*;

import java.util.List;
import javax.validation.constraints.*;

@Path("/nda")

@Api(description = "the nda API")


@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2019-11-25T14:54:20.504+05:30")


public class NdaApi  {

    @POST
    
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/xml", "application/json" })
    @ApiOperation(value = "Add a new nda to the system", notes = "", response = void.class, authorizations = {
        @Authorization(value = "ndastore_auth", scopes = {
            @AuthorizationScope(scope = "write:ndas", description = "modify ndas in your account"),
            @AuthorizationScope(scope = "read:ndas", description = "read your ndas")
        })
    }, tags={ "nda",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 405, message = "Invalid input", response = void.class) })
    public Response addNda(NDA body) {
    	return Response.ok().entity("magic!").build();
    }

    @DELETE
    @Path("/{ndaId}")
    
    @Produces({ "application/xml", "application/json" })
    @ApiOperation(value = "Deletes a nda", notes = "", response = void.class, authorizations = {
        @Authorization(value = "ndastore_auth", scopes = {
            @AuthorizationScope(scope = "write:ndas", description = "modify ndas in your account"),
            @AuthorizationScope(scope = "read:ndas", description = "read your ndas")
        })
    }, tags={ "nda",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied", response = void.class),
        @ApiResponse(code = 404, message = "Nda not found", response = void.class) })
    public Response deleteNda(@PathParam("ndaId") @ApiParam("Scenario id to delete") Long ndaId,@HeaderParam("api_key") String apiKey) {
    	return Response.ok().entity("magic!").build();
    }

    @GET
    @Path("/all")
    
    @Produces({ "application/xml", "application/json" })
    @ApiOperation(value = "Finds all Nda", notes = "return all Nda", response = NDA.class, responseContainer = "List", authorizations = {
        @Authorization(value = "ndastore_auth", scopes = {
            @AuthorizationScope(scope = "write:ndas", description = "modify ndas in your account"),
            @AuthorizationScope(scope = "read:ndas", description = "read your ndas")
        })
    }, tags={ "nda",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = NDA.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Invalid status value", response = NDA.class, responseContainer = "List") })
    public Response findAllNda() {
    	List<NDA> ndas = NdaBuilder.getNdas();
    	GenericEntity<List<NDA>> genericEntity = new GenericEntity<List<NDA>>(ndas){};
    	System.out.println(genericEntity);
    	return Response.ok(genericEntity, "application/json").build();
    }

    @GET
    @Path("/findByStatus")
    
    @Produces({ "application/xml", "application/json" })
    @ApiOperation(value = "Finds Ndas by status", notes = "Multiple status values can be provided with comma separated strings", response = NDA.class, responseContainer = "List", authorizations = {
        @Authorization(value = "ndastore_auth", scopes = {
            @AuthorizationScope(scope = "write:ndas", description = "modify ndas in your account"),
            @AuthorizationScope(scope = "read:ndas", description = "read your ndas")
        })
    }, tags={ "nda",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = NDA.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Invalid status value", response = NDA.class, responseContainer = "List") })
    public Response findNdaByStatus(@QueryParam("status") @NotNull  List<String> status) {
    	return Response.ok().entity("magic!").build();
    }

    @GET
    @Path("/findByTags")
    
    @Produces({ "application/xml", "application/json" })
    @ApiOperation(value = "Finds Ndas by tags", notes = "Muliple tags can be provided with comma separated strings. Use         tag1, tag2, tag3 for testing.", response = NDA.class, responseContainer = "List", authorizations = {
        @Authorization(value = "ndastore_auth", scopes = {
            @AuthorizationScope(scope = "write:ndas", description = "modify ndas in your account"),
            @AuthorizationScope(scope = "read:ndas", description = "read your ndas")
        })
    }, tags={ "nda",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = NDA.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Invalid tag value", response = NDA.class, responseContainer = "List") })
    public Response findNdaByTags(@QueryParam("tags") @NotNull  List<String> tags) {
    	return Response.ok().entity("magic!").build();
    }

    @GET
    @Path("/{ndaId}")
    
    @Produces({ "application/xml", "application/json" })
    @ApiOperation(value = "Find Nda by ID", notes = "Returns a single Nda", response = Scenario.class, authorizations = {
        @Authorization(value = "api_key")
    }, tags={ "nda",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Scenario.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied", response = Scenario.class),
        @ApiResponse(code = 404, message = "Scenario not found", response = Scenario.class) })
    public Response getNdaById(@PathParam("ndaId") @ApiParam("ID of scenario to return") Long ndaId) {
    	return Response.ok().entity("magic!").build();
    }

    @PUT
    
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/xml", "application/json" })
    @ApiOperation(value = "Update an existing nda", notes = "", response = void.class, authorizations = {
        @Authorization(value = "ndastore_auth", scopes = {
            @AuthorizationScope(scope = "write:ndas", description = "modify ndas in your account"),
            @AuthorizationScope(scope = "read:ndas", description = "read your ndas")
        })
    }, tags={ "nda",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied", response = void.class),
        @ApiResponse(code = 404, message = "Nda not found", response = void.class),
        @ApiResponse(code = 405, message = "Validation exception", response = void.class) })
    public Response updateNda(NDA body) {
    	return Response.ok().entity("magic!").build();
    }

    @POST
    @Path("/{ndaId}")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/xml", "application/json" })
    @ApiOperation(value = "Updates a nda in the store with form data", notes = "", response = void.class, authorizations = {
        @Authorization(value = "ndastore_auth", scopes = {
            @AuthorizationScope(scope = "write:ndas", description = "modify ndas in your account"),
            @AuthorizationScope(scope = "read:ndas", description = "read your ndas")
        })
    }, tags={ "nda" })
    @ApiResponses(value = { 
        @ApiResponse(code = 405, message = "Invalid input", response = void.class) })
    public Response updateNdaWithForm(@PathParam("ndaId") @ApiParam("ID of nda that needs to be updated") Long ndaId,@FormParam(value = "name")  String name,@FormParam(value = "status")  String status) {
    	return Response.ok().entity("magic!").build();
    }
}

