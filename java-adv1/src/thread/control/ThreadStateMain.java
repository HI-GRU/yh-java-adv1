package thread.control;

import static util.MyLogger.log;

public class ThreadStateMain {
    public static void main(String[] args) {
        try {
            Thread myThread = new Thread(new MyRunnable(), "myThread");
            log("myThread.state1 = " + myThread.getState());
            myThread.start();
            Thread.sleep(1000);
            log("myThread.state3 = " + myThread.getState());

            Thread.sleep(3000);
            log("myThread.state5 = " + myThread.getState());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            try {
                log("start");
                log("myThread.state2 = " + Thread.currentThread().getState());

                log("sleep() start");
                Thread.sleep(3000);
                log("sleep() end");
                log("myThread.state4 = " + Thread.currentThread().getState());
                log("end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
