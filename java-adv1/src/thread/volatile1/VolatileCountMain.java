package thread.volatile1;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileCountMain {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task);
        thread.start();

        sleep(1000);
        task.flag = false;
        log("flag = " + task.flag + " count = " + task.count + " in main");

        /*
        * 01:08:37.331 [ Thread-0] flag = true, count = 800000000 in while
        * 01:08:37.417 [     main] flag = false count = 878192858 in main
        * 01:08:37.417 [ Thread-0] flag = false, count = 878192858 종료
        * */
    }

    static class MyTask implements Runnable {

//        boolean flag = true;
        volatile boolean flag = true;
        long count;

        @Override
        public void run() {
            while (flag) {
                count++;

                if (count % 100_000_000 == 0) {
                    log("flag = " + flag + ", count = " + count + " in while");
                }
            }
            log("flag = " + flag + ", count = " + count + " 종료");
        }
    }
}
