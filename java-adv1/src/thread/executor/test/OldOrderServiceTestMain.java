package thread.executor.test;

import java.util.concurrent.ExecutionException;

public class OldOrderServiceTestMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String orderNo = "Order#1234"; // 예시 주문번호
//        OldOrderService orderService = new OldOrderService(); // 실행시간 3초
        NewOrderService orderService = new NewOrderService(); // 실행시간 1초
        orderService.order(orderNo);
    }
}
