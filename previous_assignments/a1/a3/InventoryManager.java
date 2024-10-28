package previous_assignments.a1.a3;

import previous_assignments.a1.a3.exceptions.NotEnoughProductException;

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


    // it will throw exception if required quantity is more than real quantity of products
    public void reduceStock(String productName, int productQuantity) throws NotEnoughProductException {
        int stockQuantity = stock.get(productName);

        if (stockQuantity < productQuantity ) {
            throw new NotEnoughProductException("it has been become less than zero");
        }
        stock.put(productName, stockQuantity - productQuantity);
    }
}
