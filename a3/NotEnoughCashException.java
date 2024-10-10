package a3;

class NotEnoughCashException extends Exception {
    public NotEnoughCashException(String message) {
        super(message);
    }
}