package io.core.experts.keycloack;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("/secured")
public class SecuredResource {
    @GET
    @Produces("text/plain;charset=UTF-8")
    public Response doGet(@Context HttpServletRequest request) {
        return Response.ok("Hello from secured!").build();
    }

    @GET
    @Path("/second")
    @Produces("text/plain;charset=UTF-8")
    public Response doSecondGet(@Context HttpServletRequest request) {
        return Response.ok("Hello from second secured!").build();
    }

    @GET
    @Path("/third")
    @Produces("text/plain;charset=UTF-8")
    public Response doThirdGet(@Context HttpServletRequest request) {
        return Response.ok("Hello from third secured!").build();
    }
}