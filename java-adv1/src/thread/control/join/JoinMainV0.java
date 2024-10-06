package thread.control.join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinMainV0 {
    public static void main(String[] args) {
        log("Start");
        Thread thread1 = new Thread(new Job(), "thread-1");
        Thread thread2 = new Thread(new Job(), "thread-2");

        thread1.start();
        thread2.start();
        log("End");

        /*
        * 순서 보장 X
        * 11:49:57.580 [     main] Start
        * 11:49:57.587 [     main] End
        * 11:49:57.587 [ thread-1] Job start
        * 11:49:57.587 [ thread-2] Job start
        * 11:49:59.596 [ thread-1] Job end
        * 11:49:59.596 [ thread-2] Job end
        * */
    }

    static class Job implements Runnable {

        @Override
        public void run() {
            log("Job start");
            sleep(2000);
            log("Job end");
        }
    }
}
