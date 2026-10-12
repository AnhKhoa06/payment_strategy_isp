package payment;

public class Main {
    public static void main(String[] args) {
        // 1. Thanh toán bằng thẻ tín dụng
        PaymentService service = new PaymentService(
                new CreditCardPayment("1234-5678-9012-3456", "123"));
        service.pay(500000);
        service.refund(100000);

        System.out.println("-----------------------");

        // 2. Đổi sang PayPal lúc chạy
        service.setStrategy(new PayPalPayment("khoa@example.com"));
        service.pay(250000);
        service.refund(50000);

        System.out.println("-----------------------");

        // 3. Ví điện tử
        service.setStrategy(new EWalletPayment("0901234567", "123456"));
        service.pay(300000);

        System.out.println("-----------------------");

        // 4. Chuyển khoản: không có refund, không có xác thực
        service.setStrategy(new BankTransferPayment("0123456789"));
        service.pay(1000000);
        service.refund(200000);   // -> báo không hỗ trợ

        System.out.println("-----------------------");

        // 5. Chứng minh OCP: thêm phương thức MỚI mà KHÔNG sửa code cũ
        service.setStrategy(amount ->
                System.out.println("Thanh toán bằng Apple Pay: " + amount));
        service.pay(150000);
    }
}