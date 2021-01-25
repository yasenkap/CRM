package com.crm.feature.client.controller;

import com.crm.feature.client.model.Client;
import com.crm.feature.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping
    List<Client> getAll(@RequestParam(required = false) String name) {
//        List<Client> clients = new ArrayList<Client>();
//        if (name == null) {
//            return clientService.getAll();}
//        else{
//            return clientService.getClientsByName(name).forEach(clients::add);}

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

    @PutMapping("/{id}")
    public void updateClient(@PathVariable("id") long id, @RequestBody final Client client){
        clientService.updateClient(id);
    }

}
