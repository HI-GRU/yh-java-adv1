package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV3 {
    public static void main(String[] args) {

        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");

        thread.start();

        sleep(15);
        log("Stop task, thread.interrupt()");
        thread.interrupt();
        log("work 스레드 인터럽트 상태1 = " + thread.isInterrupted());
    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) { // 인터럽트 상태 변경 X
                log("작업 중");
            }
            log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted()); // 계속 인터럽트 상태

            try {
                log("자원 정리");
                Thread.sleep(1000); // 인터럽트 상태이므로 예외 발생
                log("자원 종료");
            } catch(InterruptedException e) {
                log("자원 정리 실패 - 자원 정리 중 인터럽트 발생");
                log("work 스레드 인터럽트 상태3 = " + Thread.currentThread().isInterrupted());
            }
            log("작업 종료");
            // 인터럽트 발생시킨 후 스레드 인터럽트 상태를 다시 돌려놓아야 함
        }
        /*
        * 22:19:20.512 [     work] 자원 정리 실패 - 자원 정리 중 인터럽트 발생
        * 22:19:20.512 [     work] work 스레드 인터럽트 상태3 = false
        * 22:19:20.512 [     work] 작업 종료
        * */
    }
}
