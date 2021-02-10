package ir.moke.chc;

public interface TimeUtil {
    static double getTime() {
        return System.nanoTime() / 1e6;
    }
}
