package pl.woelke.customer.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<BankDetailEntity, Long> {
}
