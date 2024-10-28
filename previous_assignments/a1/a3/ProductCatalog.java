package previous_assignments.a1.a3;

import java.util.HashMap;
import java.util.Map;

class ProductCatalog {
    private Map<String, Double> products;

    public ProductCatalog() {
        products = new HashMap<>();
        products.put("Laptop", 1200.00);
        products.put("Phone", 800.00);
        products.put("Headphones", 150.00);
    }

    // returns price of the product
    public Double getProductPrice(String productName) throws NullPointerException {
        return products.get(productName);
    }
}
