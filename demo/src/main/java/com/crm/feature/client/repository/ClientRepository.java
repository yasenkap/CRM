package com.crm.feature.client.repository;

import com.crm.feature.client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("select c from Client c where c.name like :name")
    List<Client> findByNameContaining(@Param("name") String name);

}
