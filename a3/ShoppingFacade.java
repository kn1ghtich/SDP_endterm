package a3;

import java.util.Scanner;

class ShoppingFacade {
    private ProductCatalog productCatalog;
    private PaymentProcessor paymentProcessor;
    private InventoryManager inventoryManager;
    private ShippingService shippingService;

    public ShoppingFacade() {
        productCatalog = new ProductCatalog();
        paymentProcessor = new PaymentProcessor();
        inventoryManager = new InventoryManager();
        shippingService = new ShippingService();
    }

    public void placeOrder() {
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        System.out.println("Welcome to the Shopping Facade class!\nDo you want to buy something?");
        while (choice.equalsIgnoreCase("yes")) {
            // Step 1: Check if product exists
            try {
                productCatalog.getProduct(scanner.nextLine());
            } catch (NullPointerException e) {
                System.out.println("The!");
            }

            // Step 2: Check stock
            if (!inventoryManager.checkStock(productName)) {
                System.out.println("Insufficient stock for " + productName);
                return;
            }

            // Step 3: Calculate price and shipping
            Double productPrice = productCatalog.findProduct(productName);
            double shippingCost = shippingService.calculateShipping(location);
            double totalCost = productPrice + shippingCost;

            // Step 4: Process payment
            boolean paymentSuccess = paymentProcessor.processPayment(paymentType, totalCost);
            if (!paymentSuccess) {
                System.out.println("Payment failed. Order not completed.");
                return;
            }

            // Step 5: Reduce stock and ship product
            inventoryManager.reduceStock(productName);
            shippingService.shipProduct(productName);

            System.out.println("Order placed successfully for " + productName + "\n");

            System.out.println("\n\nStill want to buy something?");
        }

        System.out.println("Goodbye! Thank you for using Shopping Facade class!");
    }
}
