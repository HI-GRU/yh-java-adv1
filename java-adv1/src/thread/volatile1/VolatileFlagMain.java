package thread.volatile1;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileFlagMain {
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
        * 00:33:32.391 [     main] runFlag = true
        * 00:33:32.394 [     work] task 시작
        * 00:33:33.405 [     main] runFlag를 false로 변경 시도
        * 00:33:33.405 [     main] runFlag = false
        * 00:33:33.405 [     main] main 종료
        *
        * task 종료가 안됨!!! -> work 스레드가 while 문을 빠져나오지 못함!!
        *
        *
        * */
    }

    static class MyTask implements Runnable {

        boolean runFlag = true;

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
