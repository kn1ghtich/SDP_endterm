package a3;


public class Client {
    public static void main(String[] args) {
        ShoppingFacade shoppingFacade = new ShoppingFacade();

        // Scenario 1: Successful order
        shoppingFacade.placeOrder("Laptop", "Credit Card", "New York");

        // Scenario 2: Out of stock scenario
        shoppingFacade.placeOrder("Laptop", "Credit Card", "New York");

        // Scenario 3: Product not found
        shoppingFacade.placeOrder("Tablet", "Debit Card", "Los Angeles");

        // Scenario 4: Successful order for another product
        shoppingFacade.placeOrder("Phone", "Paypal", "San Francisco");
    }
}
