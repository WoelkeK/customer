package pl.woelke.customer.bank.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import pl.woelke.customer.company.repository.CompanyEntity;

@Getter
@Setter
@Entity
@Table(name = "bank_details")
public class BankDetailEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 255)
    @NotNull
    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Size(max = 50)
    @NotNull
    @Column(name = "bank_name", nullable = false, length = 50)
    private String bankName;

    @Size(max = 255)
    @Column(name = "notes")
    private String notes;

    @Column(name = "notesEnabled")
    private Boolean notesEnabled;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    private CompanyEntity companyEntity;

}