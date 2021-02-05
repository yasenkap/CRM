package com.crm.feature.contact.repository;

import com.crm.feature.client.model.Client;
import com.crm.feature.contact.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactRepository extends JpaRepository <Contact, Long>{

    @Query("select c from Contact c where c.client.name like %:clientName%")
    List<Contact> findByClientName(@Param("clientName") String clientName);


}
