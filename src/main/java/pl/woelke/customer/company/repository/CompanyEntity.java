package pl.woelke.customer.company.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import pl.woelke.customer.contact.repository.ContactPersonEntity;
import pl.woelke.customer.payment.repository.PaymentDetailEntity;
import pl.woelke.customer.bank.repository.BankDetailEntity;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "company")
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Size(max = 6)
    @NotNull
    @Column(name = "postCode", nullable = false, length = 6)
    private String postCode;

    @Size(max = 255)
    @NotNull
    @Column(name = "street", nullable = false)
    private String street;

    @Size(max = 255)
    @Column(name = "province")
    private String province;

    @Size(max = 255)
    @NotNull
    @Column(name = "country", nullable = false)
    private String country;

    @Size(max = 255)
    @Column(name = "postOffice")
    private String postOffice;

    @Size(max = 20)
    @NotNull
    @Column(name = "registerID", nullable = false, length = 20)
    private String registerID;

    @Size(max = 20)
    @NotNull
    @Column(name = "taxID", nullable = false, length = 20)
    private String taxID;

    @Column(name = "vatRegistered")
    private Boolean vatRegistered;

    @Column(name = "vatEuEnabled")
    private Boolean vatEuEnabled;

    @OneToMany(mappedBy = "companyEntity")
    private Set<BankDetailEntity> bankDetailEntities = new LinkedHashSet<>();

    @OneToMany(mappedBy = "companyEntity")
    private Set<ContactPersonEntity> contactPeople = new LinkedHashSet<>();

    @OneToMany(mappedBy = "companyEntity")
    private Set<PaymentDetailEntity> paymentDetailEntities = new LinkedHashSet<>();

}