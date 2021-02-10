package ir.moke.chc.api;

import ir.moke.chc.NetworkManager;
import ir.moke.chc.PingController;
import ir.moke.chc.TimeUtil;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ping")
public class PingResources {

    private String ipv4Address = NetworkManager.instance.getIpv4Address();

    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    public Response getResult(@Context HttpServletRequest req) {
        double startTimeMills = TimeUtil.getTime();

        PingController.instance.storeSession(req.getRemoteAddr());
        Integer count = PingController.instance.getCount(req.getRemoteAddr());
        count++;

        String response = "%d bytes from %s : count= %d time=%.3f ms\n";
        double endTimeMills = TimeUtil.getTime();
        int byteSize = response.getBytes().length;

        double processedTime = endTimeMills - startTimeMills;
        return Response.ok(String.format(response, byteSize, ipv4Address, count, processedTime)).build();
    }
}
