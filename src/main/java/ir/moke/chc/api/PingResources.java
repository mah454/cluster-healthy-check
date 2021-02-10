package ir.moke.chc.api;

import ir.moke.chc.NetworkManager;
import ir.moke.chc.PingController;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.TimeUnit;

@Path("/ping")
public class PingResources {

    private String ipv4Address = NetworkManager.instance.getIpv4Address();

    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    public Response getResult(@Context HttpServletRequest req) {
        String response = "";
        long startTimeMills = System.nanoTime();
        PingController.instance.storeSession(req.getRemoteAddr());
        Integer count = PingController.instance.getCount(req.getRemoteAddr());
        count++;
        response = "from " + ipv4Address + ": count=" + count + " time=";
        long endTimeMills = System.nanoTime();

        response += TimeUnit.NANOSECONDS.toMillis(endTimeMills - startTimeMills) + " ns" + "\n";

        int byteSize = response.getBytes().length;

        return Response.ok(byteSize + " bytes " + response).build();
    }
}
