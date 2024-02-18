package pl.woelke.customer.company.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
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
