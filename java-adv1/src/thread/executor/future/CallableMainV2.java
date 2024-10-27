package thread.executor.future;

import java.util.Random;
import java.util.concurrent.*;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class CallableMainV2 {
    public static void main(String[] args)
            throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(1);

        log("submit() 호출");
        Future<Integer> future = es.submit(new MyCallable());
        log("future 즉시 반환, future = " + future);

        log("future.get() [Blocking] 메서드 호출 시작 -> main 스레드 WAITING");
        Integer result = future.get();

        log("future.get() [Blocking] 메서드 호출 완료 -> main 스레드 RUNNABLE");
        log("result=" + result);
        es.close();

//        11:05:35.235 [     main] submit() 호출
//        11:05:35.239 [pool-1-thread-1] Callable 시작
//        11:05:35.239 [     main] future 즉시 반환, future = java.util.concurrent.FutureTask@6193b845[Not completed, task = thread.executor.future.CallableMainV2$MyCallable@4d405ef7]
//        11:05:35.240 [     main] future.get() [Blocking] 메서드 호출 시작 -> main 스레드 WAITING
//        11:05:37.254 [pool-1-thread-1] Callable 완료
//        11:05:37.255 [     main] future.get() [Blocking] 메서드 호출 완료 -> main 스레드 RUNNABLE
//        11:05:37.255 [     main] result=4
    }

    static class MyCallable implements Callable<Integer> {
        
        @Override
        public Integer call() throws Exception {
            log("Callable 시작");

            sleep(2000);
            int value = new Random().nextInt(10);
            log("Callable 완료");
            return value;
        }
    }
}
