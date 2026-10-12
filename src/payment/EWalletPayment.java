package payment;

public class EWalletPayment implements PaymentStrategy, Refundable, Authenticatable {
    private final String phone;
    private final String pin;

    public EWalletPayment(String phone, String pin) {
        this.phone = phone;
        this.pin = pin;
    }

    @Override
    public boolean authenticate() {
        boolean ok = pin != null && pin.length() == 6;
        System.out.println("Xác thực ví điện tử (PIN): " + (ok ? "thành công" : "thất bại"));
        return ok;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán bằng ví điện tử (" + phone + "): " + amount);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Hoàn tiền về ví điện tử: " + amount);
    }
}