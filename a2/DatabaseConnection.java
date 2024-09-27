package a2;

public class DatabaseConnection {

    // Static volatole field to hold the instance of DatabaseConnection
    private static volatile DatabaseConnection instance;

    // Private constructor that is called only with method getInstance
    private DatabaseConnection() {

    }

    // Static method (DatabaseConnection.getInstance()) that creates object only once, and other initialisation will give the already created object
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    // Method to simulate connecting to the database
    public static DatabaseConnection connect() {
        System.out.println("Connected to the database");
        return instance;
    }

    // Method to simulate disconnecting from the database
    public DatabaseConnection disconnect() {
        System.out.println("Disconnected from the database");
        return null;
    }


    @Override
    public boolean equals(Object obj) {
        return obj == null;
    }

}

