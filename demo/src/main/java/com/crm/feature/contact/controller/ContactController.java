package com.crm.feature.contact.controller;

import com.crm.feature.client.model.ClientDTO;
import com.crm.feature.client.model.ClientMapper;
import com.crm.feature.client.service.ClientService;
import com.crm.feature.contact.model.Contact;
import com.crm.feature.contact.model.ContactDTO;
import com.crm.feature.contact.model.ContactMapper;
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
    @Autowired
    private ClientService clientService;
    @Autowired
    private ContactMapper contactMapper;
    @Autowired
    private ClientMapper clientMapper;



    @GetMapping
    List<ContactDTO> getAll(@RequestParam(required = false) String clientName) {
        List<Contact> contacts = new ArrayList<>();

        if (clientName == null) {
            contactService.getAll().forEach(contacts::add);
        } else {
            contactService.getContactByNameOfClient(clientName).forEach(contacts::add);
        }
        return contactMapper.toContactDTOs(contacts);
    }


    @GetMapping("/{id}")
    ContactDTO getById(@PathVariable Long id) {
        return contactMapper.toContactDTO(contactService.getById(id));
    }

    @GetMapping("/{id}/client")
    ClientDTO getByClientId(@PathVariable Long id) { return clientMapper.toClientDTO(clientService.getByContactId(id)); }

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

    public ContactController(ContactService contactService, ClientService clientService, ContactMapper contactMapper, ClientMapper clientMapper) {
        this.contactService = contactService;
        this.clientService = clientService;
        this.contactMapper = contactMapper;
        this.clientMapper = clientMapper;
    }
}
