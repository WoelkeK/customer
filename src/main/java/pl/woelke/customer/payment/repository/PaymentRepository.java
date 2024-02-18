package pl.woelke.customer.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentDetailEntity, Long> {
}
