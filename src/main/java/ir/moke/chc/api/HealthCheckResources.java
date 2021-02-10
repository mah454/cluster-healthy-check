package ir.moke.chc.api;


import ir.moke.chc.HealthyController;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/health")
public class HealthCheckResources {

    @GET
    @Consumes({MediaType.TEXT_PLAIN})
    public Response getHealthStatus(@QueryParam("ready") Boolean isReady) {
        if (isReady == null || isReady) {
            HealthyController.instance.setReady(true);
            return Response.ok("[INFO] Application is ready\n").build();
        } else {
            HealthyController.instance.setReady(false);
            return Response.serverError().entity("[ERROR], please contact to your administrator\n").build();
        }
    }
}
