package thread.start;

import static util.MyLogger.log;

public class InnerRunnableMainV3 {

    public static void main(String[] args) {
        log("main() start");

        Thread thread = new Thread(() -> log("run() start"));
        thread.start();

        log("main() end");
    }
}
