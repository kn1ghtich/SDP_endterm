package previous_assignments.a1.a3;

import previous_assignments.a1.a3.exceptions.NoLocationException;

import java.util.HashMap;
import java.util.Map;

class ShippingService {

    private Map<String, Double> locations;

    public ShippingService() {
        locations = new HashMap<>();
        locations.put("Astana", 1.1);
        locations.put("Almaty", 1.4);
        locations.put("Karaganda", 1.05);
    }

    // find location and calculate delivery cost work together to prevent delivery mistakes
    private boolean findLocation(String location) {
        return locations.containsKey(location);
    }

    public double calculateDeliveryCost(String location) throws NoLocationException {
        if (!findLocation(location)) {
            throw new NoLocationException("No such location");
        }
        return locations.get(location);
    }
}

