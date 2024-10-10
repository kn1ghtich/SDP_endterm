package a3;

import a3.exceptions.NoLocationException;
import a3.exceptions.NotEnoughCashException;
import a3.exceptions.NotEnoughProductException;

import java.util.Scanner;

class ShoppingFacade {
    // here the each subsystem is declared
    private ProductCatalog productCatalog;
    private PaymentProcessor paymentProcessor;
    private InventoryManager inventoryManager;
    private ShippingService shippingService;

    // costructor activates
    public ShoppingFacade() {
        productCatalog = new ProductCatalog();
        paymentProcessor = new PaymentProcessor();
        inventoryManager = new InventoryManager();
        shippingService = new ShippingService();
    }


    // the only one method in facade
    public void placeOrder() {
        Scanner scanner = new Scanner(System.in);
        // important fields
        String productName;
        int productQuantity;
        Double cash = 2000.0;
        double price;
        double deliveryCost;
        double totalPrice;

        // greeting
        System.out.print("Welcome to the Shopping Facade! Do you want to buy something?(By default you have 2000 points): ");
        String choice = scanner.nextLine();

        while (choice.equalsIgnoreCase("yes")) {
            try {
                // identifying location and will return procent of delivering: Karaganda, Astana, Almaty
                // it will throw exception if it happens
                System.out.print("Enter your location: ");
                String location = scanner.nextLine();
                deliveryCost = shippingService.calculateDeliveryCost(location);

                // identifying what client purchased
                // it will throw exception if it happens
                System.out.print("What do you want to buy?: ");
                productName = scanner.nextLine();
                price = productCatalog.getProductPrice(productName);

                System.out.print("How much do you want to buy?: ");
                productQuantity = Integer.parseInt(scanner.nextLine());

                //it will process and verify correct of data
                // it will throw exception if it happens
                paymentProcessor.processPayment(cash, price, productQuantity, deliveryCost);
                totalPrice = price * productQuantity * deliveryCost;
                System.out.println("It will cost: " + totalPrice);
                System.out.print("Do you want to continue? (yes/no): ");
                choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("yes")) {
                    System.out.println("Processing...");
                } else {
                    continue;
                }

                // reduces amount of items
                inventoryManager.reduceStock(productName, productQuantity);
                cash = cash - price * productQuantity * deliveryCost;
                System.out.println("Thank you for buying " + productName + "!\nNow you have: " + cash);

                System.out.print("Do you want to continue? (yes/no): ");
                choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("no")) {
                    break;
                }
            } catch (NullPointerException e) {
                System.out.println("No such product found.");
            } catch (NotEnoughProductException e) {
                System.out.println("There is not enough such product to buy, sorry");
            } catch (NoLocationException e) {
                System.out.println("No such location found.");
            } catch (NotEnoughCashException e) {
                System.out.println("There is not enough cash to buy, sorry");
            }
            System.out.println("\n");
        }
        System.out.println("Thank you for attention and testing!");
    }
}
