package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV1 {
    public static void main(String[] args) {

        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");

        thread.start();

        sleep(4000);
        log("Stop task, runFlag = false");
        task.runFlag = false;
    }

    static class MyTask implements Runnable {
        volatile boolean runFlag = true;

        @Override
        public void run() {
            while (runFlag) {
                log("While tasking");
                sleep(3000);
            }
            log("자원 정리"); // 대략 2초 후 실행
            log("자원 종료");
        }
    }
}
