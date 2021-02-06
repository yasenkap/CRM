package com.crm.feature.client.repository;

import com.crm.feature.client.model.City;
import com.crm.feature.client.model.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ClientRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    ClientRepository repository;

//    @Test
//    public void findAllClientsWhenAdded3Clients() {
//        Client client1 = new Client(1L, "name1", City.WARSAW, "www1", "fdgdg");
//        entityManager.persist(client1);
//
//        Client client2 = new Client(2L, "name1", City.WARSAW, "www1", "fdgdg");
//        entityManager.persist(client2);
//
//        Client client3 = new Client(3L, "name1", City.WARSAW, "www1", "fdgdg");
//        entityManager.persist(client3);
//
//        Iterable<Client> clients = repository.findAll();
//
//        assertThat(clients).hasSize(3).contains(client1, client2, client3);
//    }

}