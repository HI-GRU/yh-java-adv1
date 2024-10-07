package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV2 {
    public static void main(String[] args) {

        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");

        thread.start();

        sleep(4000);
        log("Stop task, thread.interrupt()");
        thread.interrupt();
        log("work 스레드 인터럽트 상태1 = " + thread.isInterrupted());
    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    log("While tasking");
                    Thread.sleep(3000);
                    /*
                    * interrupt 시 즉각 예외 발생 X
                    * Thread.sleep()와 같은 메서드가 InterruptedException 발생시킴
                    * */
                }
            } catch (InterruptedException e) { // 인터럽트 상태 초기화함
                log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted());
                log("interrupt exception" + e.getMessage());
                log("state = " + Thread.currentThread().getState());
            }
            log("자원 종료");
        }
    }
}
