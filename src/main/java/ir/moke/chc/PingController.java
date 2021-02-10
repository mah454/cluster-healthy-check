package ir.moke.chc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PingController {

    public static PingController instance = new PingController();
    private static final Map<String, Integer> sessionMap = new ConcurrentHashMap<String, Integer>();

    private PingController() {
    }

    public void storeSession(String addr) {
        Integer currentCount = getCount(addr);
        if (currentCount == null) {
            int count = 0;
            sessionMap.put(addr, count);
        } else {
            countUp(addr);
        }
    }

    public void removeSession(String addr) {
        sessionMap.remove(addr);
    }

    public void countUp(String addr) {
        int count = getCount(addr);
        count = count + 1;
        sessionMap.put(addr, count);
    }

    public void countDown(String addr) {
        int count = getCount(addr);
        count = count - 1;
        sessionMap.put(addr, count);
    }

    public Integer getCount(String addr) {
        return sessionMap.get(addr);
    }
}
