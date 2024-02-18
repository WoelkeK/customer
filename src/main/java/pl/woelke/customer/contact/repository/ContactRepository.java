package pl.woelke.customer.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactPersonEntity, Long> {
}
