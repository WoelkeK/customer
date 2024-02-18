package pl.woelke.customer.bank.model;

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
public class BankDetail {

    private String accountNumber;
    private String bankName;
    private String notes;
    private Boolean notesEnabled;
    private CompanyEntity companyEntity;
}
