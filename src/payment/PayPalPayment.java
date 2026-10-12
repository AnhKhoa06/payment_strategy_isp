package payment;

public class PayPalPayment implements PaymentStrategy, Refundable {
    private final String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán bằng PayPal (" + email + "): " + amount);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Hoàn tiền về PayPal: " + amount);
    }
}