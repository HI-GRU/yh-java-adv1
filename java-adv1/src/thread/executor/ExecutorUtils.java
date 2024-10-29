package thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import static util.MyLogger.log;

public abstract class ExecutorUtils {
    public static void printState(ExecutorService executorService) {

        if (executorService instanceof ThreadPoolExecutor poolExecutor) {
            int poolSize = poolExecutor.getPoolSize();
            int activeCount = poolExecutor.getActiveCount();
            int queueSize = poolExecutor.getQueue().size();
            long completedTask = poolExecutor.getCompletedTaskCount();
            log("[poolSize=" + poolSize + ", activeCount=" + activeCount + ", queueSize=" + queueSize + ", completedTask=" + completedTask + "]");
        } else {
            log(executorService);
        }
    }

    public static void printState(ExecutorService executorService, String taskName) {

        if (executorService instanceof ThreadPoolExecutor poolExecutor) {
            int poolSize = poolExecutor.getPoolSize();
            int activeCount = poolExecutor.getActiveCount();
            int queueSize = poolExecutor.getQueue().size();
            long completedTask = poolExecutor.getCompletedTaskCount();
            log(taskName + " -> [poolSize=" + poolSize + ", activeCount=" + activeCount + ", queueSize=" + queueSize + ", completedTask=" + completedTask + "]");
        } else {
            log(executorService);
        }
    }
}
