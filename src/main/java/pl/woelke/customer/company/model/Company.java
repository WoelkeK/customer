package pl.woelke.customer.company.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company {

    private String name;
    private String postCode;
    private String street;
    private String province;
    private String country;
    private String postOffice;
    private String registerID;
    private String taxID;
    private Boolean vatRegistered;
    private Boolean vatEuEnabled;
}
