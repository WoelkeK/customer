package pl.woelke.customer.contact.service;

import org.springframework.stereotype.Service;
import pl.woelke.customer.contact.repository.ContactRepository;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
}
