package thread.control;

import thread.start.HelloRunnable;

import static util.MyLogger.log;

public class ThreadInfoMain {
    public static void main(String[] args) {

        // main 스레드
        Thread mainThread = Thread.currentThread();
        log("mainThread = " + mainThread);
        log("mainThread.threadId() = " + mainThread.threadId());
        log("mainThread.getName() = " + mainThread.getName());
        log("mainThread.getPriority() = " + mainThread.getPriority());
        log("mainThread.getThreadGroup() = " + mainThread.getThreadGroup());
        log("mainThread.getState() = " + mainThread.getState());
        log("mainThread.isDaemon() = " + mainThread.isDaemon());

         /*
         * 12:04:35.567 [     main] mainThread = Thread[#1,main,5,main]
         * 12:04:35.572 [     main] mainThread.threadId() = 1
         * 12:04:35.572 [     main] mainThread.getName() = main
         * 12:04:35.575 [     main] mainThread.getPriority() = 5
         * 12:04:35.576 [     main] mainThread.getThreadGroup() = java.lang.ThreadGroup[name=main,maxpri=10]
         * 12:04:35.576 [     main] mainThread.getState() = RUNNABLE
         * 12:04:35.576 [     main] mainThread.isDaemon() = false
         */

        Thread myThread = new Thread(new HelloRunnable(),"myThread");
        log("myThread = " + myThread);
        log("myThread.threadId() = " + myThread.threadId());
        log("myThread.getName() = " + myThread.getName());
        log("myThread.getPriority() = " + myThread.getPriority());
        log("myThread.getThreadGroup() = " + myThread.getThreadGroup());
        log("myThread.getState() = " + myThread.getState());
        log("myThread.isDaemon() = " + myThread.isDaemon());

        /*
        12:06:30.161 [     main] myThread = Thread[#22,myThread,5,main]
        12:06:30.161 [     main] myThread.threadId() = 22
        12:06:30.161 [     main] myThread.getName() = myThread
        12:06:30.162 [     main] myThread.getPriority() = 5
        12:06:30.162 [     main] myThread.getThreadGroup() = java.lang.ThreadGroup[name=main,maxpri=10]
        12:06:30.162 [     main] myThread.getState() = NEW
        12:06:30.162 [     main] myThread.isDaemon() = false
         */
    }
}
