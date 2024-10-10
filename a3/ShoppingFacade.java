package a3;
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

    public void placeOrder(String productName, String paymentType, String location) {
        System.out.println("\nPlacing order for: " + productName);

        // Step 1: Check if product exists
        if (!productCatalog.productExists(productName)) {
            System.out.println("Product not found in catalog.");
            return;
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
    }
}
