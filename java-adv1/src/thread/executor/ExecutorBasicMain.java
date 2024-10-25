package thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static thread.executor.ExecutorUtils.printState;
import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ExecutorBasicMain {
    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(2, 2, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

        log("==초기 상태==");
        printState(es);

        es.execute(new RunnableTask("taskA"));
        es.execute(new RunnableTask("taskB"));
        es.execute(new RunnableTask("taskC"));
        es.execute(new RunnableTask("taskD"));

        log("==작업 수행 중==");
        printState(es);

//        21:55:53.621 [     main] ==초기 상태==
//        21:55:53.632 [     main] [poolSize=0, activeCount=0, queueSize=0, completedTask=0]
//        21:55:53.634 [     main] ==작업 수행 중==
//        21:55:53.634 [     main] [poolSize=2, activeCount=2, queueSize=2, completedTask=0]

        sleep(3000);
        log("==작업 수행 완료==");
        printState(es);

//        21:55:56.648 [     main] ==작업 수행 완료==
//        21:55:56.648 [     main] [poolSize=2, activeCount=0, queueSize=0, completedTask=4]

        es.close();
        log("==shutdown 완료==");
        printState(es);

//        21:55:56.649 [     main] ==shutdown 완료==
//        21:55:56.649 [     main] [poolSize=0, activeCount=0, queueSize=0, completedTask=4]
    }
}
