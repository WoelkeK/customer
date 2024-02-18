package pl.woelke.customer.payment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.woelke.customer.company.repository.CompanyEntity;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Payment {

    private String paymentMethod;
    private String paymentTerms;
    private String currency;
    private CompanyEntity companyEntity;
}
