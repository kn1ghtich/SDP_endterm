package a3;

import java.util.HashMap;
import java.util.Map;

class InventoryManager {
    private Map<String, Integer> stock;

    public InventoryManager() {
        stock = new HashMap<>();
        stock.put("Laptop", 10);
        stock.put("Phone", 20);
        stock.put("Headphones", 30);
    }

    public boolean checkStock(String productName) {
        return stock.getOrDefault(productName, 0) > 0;
    }

    public void reduceStock(String productName) {
        if (checkStock(productName)) {
            stock.put(productName, stock.get(productName) - 1);
            System.out.println(productName + " stock reduced by 1.");
        } else {
            System.out.println(productName + " is out of stock.");
        }
    }
}