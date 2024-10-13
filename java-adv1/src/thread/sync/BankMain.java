package thread.sync;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankMain {
    public static void main(String[] args) throws InterruptedException {
        // 두 스레드가 동시에 출금하는 경우
//        BackAccount account = new BackAccountV1(1000);
        
        // synchronized 예제
//        BackAccount account = new BackAccountV2(1000);

        // synchronized block
//        BackAccount account = new BackAccountV3(1000);

        // ReentrantLock
//        BackAccount account = new BackAccountV4(1000);

        // ReentrantLock lock.tryLock()
//        BackAccount account = new BackAccountV5(1000);

        // ReentrantLock lock.tryLock(500, TimeUnit.MILLISECONDS)
        BackAccount account = new BackAccountV6(1000);

        Thread t1 = new Thread(new WithdrawTask(account, 800), "t1");
        Thread t2 = new Thread(new WithdrawTask(account, 800), "t2");

        t1.start();
        t2.start();
        
        sleep(500); // 검증 완료까지 잠시 대기
        log("t1 state: " + t1.getState());
        log("t2 state: " + t2.getState());
//        synchronized 예제
//        16:11:05.727 [     main] t1 state: BLOCKED
//        16:11:05.727 [     main] t2 state: TIMED_WAITING
        
        t1.join();
        t2.join();

        log("최종 잔액: " + account.getBalance());
        /*
        * 12:29:50.724 [       t2] 거래 종료
        * 12:29:50.724 [       t1] 거래 종료
        * 12:29:50.726 [     main] 최종 잔액: -600
        * */

        /*
        * 15:45:23.774 [       t2] 거래 시작: BackAccountV2
        * 15:45:23.775 [       t2] [검증 시작] 출금액: 800, 잔액: 200
        * 15:45:23.775 [       t2] [검증 실패] 출금액: 800, 잔액: 200
        * 15:45:23.777 [     main] 최종 잔액: 200
        * */
    }
}
