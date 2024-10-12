package thread.sync;

public class WithdrawTask implements Runnable {

    private final BackAccount account;
    private final int amount;

    public WithdrawTask(BackAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(amount);
    }
}
