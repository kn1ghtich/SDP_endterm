package a2;

public class Main {
    public static void main(String[] args) {
        // Creating instance of DatabaseConnection
        DatabaseConnection.getInstance();


        // Creating link variable of DatabaseConnection
        DatabaseConnection db1 = DatabaseConnection.connect(); // Output: Connected to the database

        // Creating second link variable of DatabaseConnection
        DatabaseConnection db2 = DatabaseConnection.connect(); // Output: Connected from the database

        // Verifying that both instances are the same and one of them is not null
        if (db1 == db2 && db1 != null) {
            System.out.println("Singleton is done");
        } else {
            System.out.println("Somewhere is mistake and singleton is not done");
        }



        db1.disconnect();
        db2.disconnect();

        if (db1.equals(null)) {
            System.out.println("Disconnected");
        } else {
            System.out.println("Somewhere is mistake and disconneted is not done");
        }


    }
}
