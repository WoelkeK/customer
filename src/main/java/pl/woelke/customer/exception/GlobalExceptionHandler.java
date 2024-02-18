package pl.woelke.customer.exception;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Locale;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(CompanyNotFoundException.class)
    public ResponseEntity<CustomErrorType> customHandleNotFound(Exception ex, WebRequest request, Locale locale) {
        String messageError = messageSource.getMessage(
                "company.not.found", null, locale
        );
        return new ResponseEntity<>(new CustomErrorType(messageError, ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ContactNotFoundException.class)
    public ResponseEntity<CustomErrorType> handleContactNotFoundException(ContactNotFoundException ex, WebRequest request) {
        Locale locale = LocaleContextHolder.getLocale();

        String messageError = messageSource.getMessage(
                "contact.not.found", null, locale
        );
        return new ResponseEntity<>(new CustomErrorType(messageError, ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BankNotFoundException.class)
    public ResponseEntity<CustomErrorType> handleBankNotFoundException(ContactNotFoundException ex, WebRequest request) {
        Locale locale = LocaleContextHolder.getLocale();

        String messageError = messageSource.getMessage(
                "contact.not.found", null, locale
        );
        return new ResponseEntity<>(new CustomErrorType(messageError, ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PaymentNotFoundException.class)
    public ResponseEntity<CustomErrorType> handlePaymentNotFoundException(ContactNotFoundException ex, WebRequest request) {
        Locale locale = LocaleContextHolder.getLocale();

        String messageError = messageSource.getMessage(
                "contact.not.found", null, locale
        );
        return new ResponseEntity<>(new CustomErrorType(messageError, ex.getMessage()), HttpStatus.NOT_FOUND);
    }

}
