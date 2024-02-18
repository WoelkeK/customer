package pl.woelke.customer.payment.repository;

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
@Table(name = "payment_details")
public class PaymentDetailEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 50)
    @NotNull
    @Column(name = "payment_method", nullable = false, length = 50)
    private String paymentMethod;

    @Size(max = 50)
    @NotNull
    @Column(name = "payment_terms", nullable = false, length = 50)
    private String paymentTerms;

    @Size(max = 3)
    @NotNull
    @Column(name = "currency", nullable = false, length = 3)
    private String currency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private CompanyEntity companyEntity;

}