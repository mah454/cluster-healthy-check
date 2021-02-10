package ir.moke.chc;

public class HealthyController {

    public static HealthyController instance = new HealthyController() ;
    private static boolean isReady = true ;

    private HealthyController() {
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }
}
