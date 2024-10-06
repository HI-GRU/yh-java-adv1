package thread.control.test;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinTest1Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyTask(), "t1");
        Thread t2 = new Thread(new MyTask(), "t2");
        Thread t3 = new Thread(new MyTask(), "t3");

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        t3.start();
        t3.join();

        log("모든 스레드 실행 완료");

        /*
        * 12:24:55.711 [       t1] 0
        * 12:24:56.716 [       t1] 1
        * 12:24:57.727 [       t1] 2
        * 12:24:58.728 [       t2] 0
        * 12:24:59.736 [       t2] 1
        * 12:25:00.742 [       t2] 2
        * 12:25:01.757 [       t3] 0
        * 12:25:02.767 [       t3] 1
        * 12:25:03.768 [       t3] 2
        * 12:25:04.778 [     main]
        * 모든 스레드 실행 완료
        */
    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                log(i);
                sleep(1000);
            }
        }
    }
}
