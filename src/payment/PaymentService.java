package payment;

public class PaymentService {
    private PaymentStrategy strategy;

    public PaymentService(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    // Cho phép đổi chiến lược lúc chạy
    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void pay(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Số tiền phải lớn hơn 0");
        }
        // Chỉ xác thực nếu phương thức này CÓ hỗ trợ xác thực
        if (strategy instanceof Authenticatable auth) {
            if (!auth.authenticate()) {
                System.out.println("Xác thực thất bại, hủy giao dịch.");
                return;
            }
        }
        strategy.pay(amount);
    }

    public void refund(double amount) {
        // Chỉ hoàn tiền nếu phương thức này CÓ hỗ trợ hoàn tiền
        if (strategy instanceof Refundable r) {
            r.refund(amount);
        } else {
            System.out.println("Phương thức này không hỗ trợ hoàn tiền.");
        }
    }
}