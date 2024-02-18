package pl.woelke.customer.exception;

public class PaymentNotFoundException extends Exception{
    public PaymentNotFoundException() {
    }

    public PaymentNotFoundException(String message) {
        super(message);
    }

    public PaymentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
