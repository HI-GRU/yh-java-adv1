package thread.volatile1;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileFlagMain2 {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        log("runFlag = " + task.runFlag);
        thread.start();

        sleep(1000);
        log("runFlag를 false로 변경 시도");
        task.runFlag = false;
        log("runFlag = " + task.runFlag);
        log("main 종료");

        /*
         * 00:52:17.625 [     main] runFlag = true
         * 00:52:17.626 [     work] task 시작
         * 00:52:18.633 [     main] runFlag를 false로 변경 시도
         * 00:52:18.633 [     work] task 종료
         * 00:52:18.633 [     main] runFlag = false
         * 00:52:18.633 [     main] main 종료
         * */
    }

    static class MyTask implements Runnable {

        volatile boolean runFlag = true;

        @Override
        public void run() {
            log("task 시작");

            while (runFlag) {
                // runFlag가 false로 변하면 탈출
            }
            log("task 종료");
        }
    }
}
