package thread.start;

public class DaemonThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() end");
        DaemonThread daemonThread  = new DaemonThread();
        daemonThread.setDaemon(true); // 데몬 스레드 여부
        // 데몬 스레드 종료 여부와 상관없이 자바는 종료됨 (non-daemon thread 종료되면 자바 종료)
        daemonThread.start();
        System.out.println(Thread.currentThread().getName() + ": main() end");
    }

    static class DaemonThread extends Thread {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": run() start");

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + ": run() end");
        }
    }
}
