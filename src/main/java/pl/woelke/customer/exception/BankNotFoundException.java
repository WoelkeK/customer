package pl.woelke.customer.exception;

public class BankNotFoundException extends Exception{

    public BankNotFoundException() {
    }

    public BankNotFoundException(String message) {
        super(message);
    }

    public BankNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
