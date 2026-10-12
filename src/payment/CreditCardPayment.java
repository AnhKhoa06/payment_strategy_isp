package payment;

public class CreditCardPayment implements PaymentStrategy, Refundable, Authenticatable {
    private final String cardNumber;
    private final String cvv;

    public CreditCardPayment(String cardNumber, String cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    @Override
    public boolean authenticate() {
        // Giả lập kiểm tra CVV
        boolean ok = cvv != null && cvv.length() == 3;
        System.out.println("Xác thực thẻ tín dụng (CVV): " + (ok ? "thành công" : "thất bại"));
        return ok;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán bằng thẻ tín dụng: " + amount);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Hoàn tiền về thẻ tín dụng: " + amount);
    }
}