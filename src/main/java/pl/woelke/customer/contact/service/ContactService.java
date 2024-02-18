package pl.woelke.customer.contact.service;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.woelke.customer.contact.model.ContactPerson;
import pl.woelke.customer.contact.repository.ContactPersonEntity;
import pl.woelke.customer.contact.repository.ContactRepository;
import pl.woelke.customer.exception.ContactNotFoundException;

import java.util.List;

@Service
@Slf4j
public class ContactService {

    private final ContactRepository contactRepository;
    private final ModelMapper modelMapper;

    public ContactService(ContactRepository contactRepository, ModelMapper modelMapper) {
        this.contactRepository = contactRepository;
        this.modelMapper = modelMapper;
    }

    public List<ContactPerson> getAllContacts() {
        log.debug("getAllContacts()");
        List<ContactPersonEntity> contactPersonEntities = contactRepository.findAll();
        return contactPersonEntities.stream()
                .map(contactPersonEntity -> modelMapper.map(contactPersonEntity, ContactPerson.class))
                .toList();
    }

    public ContactPerson addContact(ContactPerson contactPerson) {
        log.debug("addContact()");
        ContactPersonEntity contactPersonEntity = modelMapper.map(contactPerson, ContactPersonEntity.class);
        return modelMapper.map(contactRepository.save(contactPersonEntity), ContactPerson.class);
    }

    public ContactPerson findContactById(Long id) throws ContactNotFoundException {
        log.debug("findContactById({})", id);
        ContactPersonEntity contactPersonEntity = contactRepository.findById(id).orElseThrow(
                () -> new ContactNotFoundException("Contact not found with id: " + id));
        return modelMapper.map(contactPersonEntity, ContactPerson.class);
    }

    public ContactPerson updateContact(Long id, ContactPerson contactPerson) throws ContactNotFoundException {
        log.debug("updateContact({}, {})", id, contactPerson);
        ContactPersonEntity contactPersonEntity = contactRepository.findById(id).orElseThrow(
                () -> new ContactNotFoundException("Contact not found with id: " + id));
        ContactPersonEntity personEntity = modelMapper.map(contactPerson, ContactPersonEntity.class);
        personEntity.setId(contactPersonEntity.getId());
        return modelMapper.map(contactRepository.save(personEntity), ContactPerson.class);
    }

    public void deleteContact(Long id) throws ContactNotFoundException {
        log.debug("deleteContact({})", id);
        ContactPersonEntity contactPersonEntity = contactRepository.findById(id).orElseThrow(
                () -> new ContactNotFoundException("Contact not found with id: " + id));
        contactRepository.delete(contactPersonEntity);
    }
}
