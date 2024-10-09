package thread.control.yield;

import static util.ThreadUtils.sleep;

public class YieldMain {

    static final int THREAD_COUNT = 1000;

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(new MyRunnable());
            thread.start();
        }
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {

                // 1. empty
                // 대략 10ms 마다 하나의 스레드가 실행됨
                System.out.println(Thread.currentThread().getName() + " - " + i);

                // 2. sleep
                // 아주 잠깐 RUNNABLE -> TIMED_WAITING 으로 변경되어 실행 스케줄링에서 잠시 제외
                // CPU 실행 기회를 다른 스레드에 넘김
                // 양보할 사람이 없는데 혼자 양보하는 상황 발생 가능
//                sleep(1);

                // 3. yield
                // RUNNABLE 의 경우 실행 상태 (Running) 와 실행 대기 상태 (Ready) 가 있다.
                // yield() 호출 시 RUNNABLE 상태 유지하며 (Ready) CPU 양보
                // 자바는 위 두 상태를 구분하지 못함 -> 운영체제가 최적화하는 것
                // 양보할 사람이 없다면 계속 실행 가능
                Thread.yield();
            }
        }
    }
}
