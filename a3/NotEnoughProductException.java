package a3;

class NotEnoughProductException extends Exception {
    public NotEnoughProductException(String message) {
        super(message);
    }
}