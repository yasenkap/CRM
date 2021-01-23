package com.crm.feature.contact.model;

import com.crm.feature.client.model.Client;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    private Client client;
    @Column(nullable = false, unique = true)
    @Email(message = "Invalid email")
    private String email;
    @Column(nullable = false, unique = true)
    private String phoneNumber;
    @Column(nullable = false)
    private String position;

    public Contact() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    public Contact(Long id, String name, String surname, Client client, @Email(message = "Invalid email") String email, String phoneNumber, String position) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.client = client;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.position = position;
    }
}
