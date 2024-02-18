package pl.woelke.customer.exception;

public class CompanyNotFoundException extends Exception{

    public CompanyNotFoundException() {
    }

    public CompanyNotFoundException(String message) {
        super(message);
    }

    public CompanyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
