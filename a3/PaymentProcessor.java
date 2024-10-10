package a3;

class PaymentProcessor {
    public boolean processPayment(String paymentType, Double amount) {
        if (amount > 0) {
            System.out.println(paymentType + " payment of $" + amount + " processed successfully.");
            return true;
        } else {
            System.out.println("Payment failed. Invalid amount.");
            return false;
        }
    }
}
