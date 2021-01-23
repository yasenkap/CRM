package com.crm.feature.client.controller;

import com.crm.feature.client.model.Client;
import com.crm.feature.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    List<Client> getAll() {
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    Client getById(@PathVariable Long id) {
        return clientService.getById(id);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        clientService.delete(id);
    }

    @PostMapping
    public void saveClient(@RequestBody final Client client) {
        clientService.saveClient(client);
    }

}
