package pl.woelke.customer.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomErrorType {

    private String errorType;
    private String errorMessage;

    public CustomErrorType(String messageError) {
    }
}

