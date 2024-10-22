package thread.cas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static util.MyLogger.log;

public class CasMainV3 {

    private static final int THREAD_COUNT = 10000;

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println("start value = " + atomicInteger.get());

        Runnable runnable = () -> incrementAndGet(atomicInteger);

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int result = atomicInteger.get();
        System.out.println("result = " + result);
//        start value = 0
//        20:27:19.578 [ Thread-1] getValue: 0
//        20:27:19.578 [ Thread-0] getValue: 0
//        20:27:19.580 [ Thread-1] result: true
//        20:27:19.580 [ Thread-0] result: false
//        20:27:19.580 [ Thread-0] getValue: 1
//        20:27:19.580 [ Thread-0] result: true
//        result = 2
    }

    private static int incrementAndGet(AtomicInteger atomicInteger) {
        int getValue;
        boolean result;

        do {
            getValue = atomicInteger.get();
//            log("getValue: " + getValue);
            result = atomicInteger.compareAndSet(getValue, getValue + 1);
//            log("result: " + result);
        } while (!result);

        return getValue + 1;
    }
}
