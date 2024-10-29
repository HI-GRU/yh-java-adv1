package thread.executor.reject;

import thread.executor.RunnableTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RejectMainV3 {
    public static void main(String[] args) {
        ExecutorService executor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new SynchronousQueue<>()
                , new ThreadPoolExecutor.CallerRunsPolicy());

        executor.submit(new RunnableTask("task1"));
        executor.submit(new RunnableTask("task2"));
        executor.submit(new RunnableTask("task3"));
        executor.submit(new RunnableTask("task4"));

        executor.close();

        // 골 때리는 정책
//        22:30:48.280 [pool-1-thread-1] task1시작
//        22:30:48.280 [     main] task2시작
//        22:30:49.294 [     main] task2완료
//        22:30:49.294 [pool-1-thread-1] task1완료
//        22:30:49.294 [     main] task3시작
    }
}
