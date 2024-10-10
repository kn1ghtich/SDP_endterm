package a3;

class ShippingService {
    public void shipProduct(String productName) {
        System.out.println("Shipping " + productName + " to customer.");
    }

    public double calculateShipping(String location) {
        // Flat rate shipping for simplicity
        double shippingCost = 10.00;
        System.out.println("Shipping cost to " + location + " is $" + shippingCost);
        return shippingCost;
    }
}

