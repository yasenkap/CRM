package com.crm.feature.client.repository;

import com.crm.feature.client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByNameContaining(String name);

}
