package io.core.experts.keycloack;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("/")
public class UnSecuredResource {
    @GET
    @Produces("text/plain;charset=UTF-8")
    public Response doGet(@Context HttpServletRequest request) {
        return Response.ok("Hello!").build();
    }
}