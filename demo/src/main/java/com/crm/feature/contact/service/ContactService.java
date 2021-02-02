package com.crm.feature.contact.service;

import com.crm.feature.client.model.Client;
import com.crm.feature.contact.model.Contact;
import com.crm.feature.contact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ContactService {

    @Autowired
    private final ContactRepository contactRepository;

    public List<Contact> getAll() {
        return contactRepository.findAll();
    }

    public Contact getById(Long id) {
        return contactRepository.findById(id).orElseThrow();
    }

    public void delete(Long id) {
        contactRepository.deleteById(id);
    }

    public void saveContact(final Contact contact) {
        contactRepository.save(contact);
    }

    public Contact updateContact(Long id, final Contact contact) {

        Optional<Contact> contactToUpdate = contactRepository.findById(id);
        Contact updatedContact = contactToUpdate.get();

        if (contactToUpdate.isPresent()) {
            updatedContact.setName(contact.getName());
            updatedContact.setSurname(contact.getSurname());
            updatedContact.setEmail(contact.getEmail());
            updatedContact.setPosition(contact.getPosition());
            updatedContact.setPhoneNumber(contact.getPhoneNumber());
            updatedContact = contactRepository.save(updatedContact);
        }
        return updatedContact;
    }

    public List<Contact> getContactByNameOfClient(String clientName) {
        return contactRepository.findByClientName(clientName);
    }

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public ContactRepository getContactRepository() {
        return contactRepository;
    }
}
