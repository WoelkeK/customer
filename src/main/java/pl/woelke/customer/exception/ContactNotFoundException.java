package pl.woelke.customer.exception;

public class ContactNotFoundException extends Exception{
    public ContactNotFoundException() {
    }

    public ContactNotFoundException(String message) {
        super(message);
    }

    public ContactNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ContactNotFoundException(Throwable cause) {
        super(cause);
    }
}
