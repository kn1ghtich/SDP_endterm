package previous_assignments.a1.a3;

import previous_assignments.a1.a3.exceptions.NotEnoughCashException;

class PaymentProcessor {
    //throws exception if cash < total cost
    public void processPayment(Double cash, Double price, int productQuantity, Double deliveryCost) throws NotEnoughCashException {
        if (cash < price * productQuantity * deliveryCost) {
            throw new NotEnoughCashException("Not enough cash");
        }
    }
}
