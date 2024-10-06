package thread.control;

public class CheckedExceptionMain {
    public static void main(String[] args) throws Exception {
        throw new Exception();
    }

    static class CheckedRunnable implements Runnable {

        @Override
        public void run() /* throws Exception */ {
//            throw new Exception(); 부모의 checked Exception의 하위 타입 예외만을 던질 수 있다.
        }
    }
}
