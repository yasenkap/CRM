package com.crm.feature.client.repository;

import com.crm.feature.client.model.Client;
import com.crm.feature.vacancy.model.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("select c from Client c where c.name like %:name%")
    List<Client> findByNameContaining(@Param("name") String name);

    @Query("select c from Client c join c.contacts t where t.id = : id")
    Client getByContactId(@Param("id") long id);

}
