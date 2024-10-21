package thread.cas.increment;

import static util.MyLogger.log;

public class IncrementPerformanceMain {
    public static final long COUNT = 100_000_000;

    public static void main(String[] args) {
        test(new BasicInteger()); // 기본
        test(new VolatileInteger()); // volatile
        test(new SyncInteger()); // synchronized
        test(new MyAtomicInteger()); // AtomicInteger
    }

    private static void test(IncrementInteger incrementInteger) {
        long startMs = System.currentTimeMillis();

        for (int i = 0; i < COUNT; i++) {
            incrementInteger.increment();
        }

        long endMs = System.currentTimeMillis();
        log(incrementInteger.getClass().getSimpleName() + " ms: " + (endMs - startMs));

//        21:29:43.605 [     main] BasicInteger ms: 6
//        21:29:43.774 [     main] VolatileInteger ms: 166
//        21:29:44.237 [     main] SyncInteger ms: 462
//        21:29:44.457 [     main] MyAtomicInteger ms: 219
    }
}
