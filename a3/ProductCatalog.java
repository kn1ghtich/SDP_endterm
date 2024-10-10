package a3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class ProductCatalog {
    private Map<String, Integer> products;

    public ProductCatalog() {
        products = new HashMap<>();
        products.put("Bananas", 3);
        products.put("Apples", 1);
        products.put("Potato", 5);
    }

    public int getProduct(String product) throws NullPointerException {
        return products.get(product);
    }
}
