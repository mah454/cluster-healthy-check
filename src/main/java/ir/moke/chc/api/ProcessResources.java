package ir.moke.chc.api;

import ir.moke.chc.HealthyController;
import ir.moke.chc.NetworkManager;
import ir.moke.chc.TimeUtil;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/process")
public class ProcessResources {
    private String ipv4Address = NetworkManager.instance.getIpv4Address();

    @GET
    @Consumes({MediaType.TEXT_PLAIN})
    public Response getResult(@QueryParam("delay") long delay) {
        double startTimeMills = TimeUtil.getTime();
        boolean ready = HealthyController.instance.isReady();
        if (ready) {
            sleep(delay);
            double endTimeMills = TimeUtil.getTime();
            String response = String.format("[%s] Process completed after %.2f milliseconds\n", ipv4Address, endTimeMills - startTimeMills);
            return Response.ok(response).build();
        } else {
            throw new RuntimeException("[ERROR] Application is not ready");
        }
    }

    public static void sleep(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
