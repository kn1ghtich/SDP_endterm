package a3;

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

    public Double getProductPrice(String productName) throws NullPointerException {
        return products.get(productName);
    }

    /////////////////
    public boolean productExists(String productName) {
        return products.containsKey(productName);
    }
}
