package com.crm.feature.client.service;

import com.crm.feature.client.model.Client;
import com.crm.feature.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientService {

    @Autowired
    private final ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Client getById(Long id) {
        return clientRepository.findById(id).orElseThrow();
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    public void saveClient(final Client client) {
        clientRepository.save(client);
    }

    public Client updateClient(Long id) {

        Optional<Client> clientToUpdate = clientRepository.findById(id);
        Client updatedClient = clientToUpdate.get();

        if (clientToUpdate.isPresent()) {
            updatedClient.setName(clientToUpdate.get().getName());
            updatedClient.setCity(clientToUpdate.get().getCity());
            updatedClient.setDescription(clientToUpdate.get().getDescription());
            updatedClient.setWebsite(clientToUpdate.get().getWebsite());
            updatedClient = clientRepository.save(updatedClient);
        }
        return updatedClient;
    }

    public List<Client> getClientByName(String name) {
        return clientRepository.findByNameContaining(name);
    }

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientRepository getClientRepository() {
        return clientRepository;
    }
}
