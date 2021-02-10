package ir.moke.chc;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class NetworkManager {

    public static NetworkManager instance = new NetworkManager();

    private NetworkManager() {

    }

    public Inet4Address getInet4Address() {
        Inet4Address inet4Address = null;
        try {
            NetworkInterface networkInterface = NetworkInterface.getByName("eth0");
            Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress inetAddress = inetAddresses.nextElement();
                if (inetAddress instanceof Inet4Address) {
                    inet4Address = (Inet4Address) inetAddress;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inet4Address;
    }

    public String getIpv4Address() {
        Inet4Address inet4Address = getInet4Address();
        return inet4Address.getHostAddress();
    }
}
