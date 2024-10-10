package a3;

class PaymentProcessor {
    public void processPayment(Double cash, Double price, int productQuantity, Double deliveryCost) throws NotEnoughCashException {
        if (cash < price * productQuantity * deliveryCost) {
            throw new NotEnoughCashException("Not enough cash");
        }

    }
}
