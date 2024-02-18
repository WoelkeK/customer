package pl.woelke.customer.contact.model;


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
public class ContactPerson {

    private String name;
    private String position;
    private String email;
    private String phoneNumber;
    private CompanyEntity companyEntity;
}
