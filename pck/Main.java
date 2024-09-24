package pck;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        FoodProduct fp = new FoodProduct(1000);
        ElectronicsProduct ep = new ElectronicsProduct(1000);
        ClothProduct cp = new ClothProduct(1000);
        DiscountCalculator DC = new DiscountCalculator();
        System.out.println(DC.calculateDiscount(fp));
        System.out.println(DC.calculateDiscount(ep));
        System.out.println(DC.calculateDiscount(cp));
    }
}

class DiscountCalculator {
    public double calculateDiscount(Discountable product) {
        try {
            return product.getDiscount();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}

class FoodProduct implements Discountable {
    private double price;

    public FoodProduct(double price) {
        this.price = price;
    }

    @Override
    public double getDiscount() {
        return price * 0.1;
    }
}

class ElectronicsProduct implements Discountable {
    private double price;

    public ElectronicsProduct(double price) {
        this.price = price;
    }

    @Override
    public double getDiscount() {
        return price * 0.05;
    }
}

class ClothProduct implements Discountable {
    private double price;

    public ClothProduct(double price) {
        this.price = price;
    }

    @Override
    public double getDiscount() {
        return price * 0.2;
    }
}