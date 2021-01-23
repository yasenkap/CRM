package com.crm.feature.client.repository;

import com.crm.feature.client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByNameContaining(String name);

}
