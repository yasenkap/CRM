package com.crm.feature.contact.controller;

import com.crm.feature.contact.model.Contact;
import com.crm.feature.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    List<Contact> getAll(@RequestParam(required = false) String clientName) {
        List<Contact> contacts = new ArrayList<>();

        if (clientName == null) {
            contactService.getAll().forEach(contacts::add);
        } else {
            contactService.getContactByNameOfClient(clientName).forEach(contacts::add);
        }
        return contacts;
    }


    @GetMapping("/{id}")
    Contact getById(@PathVariable Long id) {
        return contactService.getById(id);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        contactService.delete(id);
    }

    @PostMapping
    public void saveContact(@RequestBody final Contact contact) {
        contactService.saveContact(contact);
    }

    @PutMapping("/{id}")
    public Contact updateContact(@PathVariable("id") long id, @RequestBody final Contact contact) {
        return contactService.updateContact(id, contact);
    }
}
