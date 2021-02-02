package com.crm.feature.client.controller;

import com.crm.feature.client.model.Client;
import com.crm.feature.client.service.ClientService;
import com.crm.feature.contact.model.Contact;
import com.crm.feature.contact.service.ContactService;
import com.crm.feature.vacancy.model.Vacancy;
import com.crm.feature.vacancy.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private VacancyService vacancyService;
    @Autowired
    private ContactService contactService;

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping
    List<Client> getAll(@RequestParam(required = false) String name) {
        List<Client> clients = new ArrayList<Client>();

        if (name == null) {
            clientService.getAll().forEach(clients::add);
        } else {
            clientService.getClientByName(name).forEach(clients::add);
        }

        return clients;
    }

    @GetMapping("/{id}/vacancies")
    List<Vacancy> getVacanciesByClient(@PathVariable("id") Long id) {
        Client selectedClient = clientService.getById(id);
        List<Vacancy> vacancies = new ArrayList<>();
        vacancyService.getVacanciesByNameOfClient(selectedClient.getName()).forEach(vacancies::add);
        return vacancies;
    }

    @GetMapping("/{id}/contacts")
    List<Contact> getContactsByClient(@PathVariable("id") Long id) {
        Client selectedClient = clientService.getById(id);
        List<Contact> contacts= new ArrayList<>();
        contactService.getContactByNameOfClient(selectedClient.getName()).forEach(contacts::add);
        return contacts;
    }


    @GetMapping("/{id}")
    Client getById(@PathVariable Long id) {
        return clientService.getById(id);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        clientService.delete(id);
    }

    @PostMapping()
    public void saveClient(@RequestBody final Client client) {
        clientService.saveClient(client);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable("id") long id, @RequestBody final Client client) {
        return clientService.updateClient(id, client);
    }

    public ClientController(ClientService clientService, VacancyService vacancyService, ContactService contactService) {
        this.clientService = clientService;
        this.vacancyService = vacancyService;
        this.contactService = contactService;
    }
}
