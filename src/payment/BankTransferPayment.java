package payment;

public class BankTransferPayment implements PaymentStrategy {
    private final String accountNumber;

    public BankTransferPayment(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán bằng chuyển khoản (TK " + accountNumber + "): " + amount);
    }
}