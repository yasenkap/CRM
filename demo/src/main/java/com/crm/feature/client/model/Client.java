package com.crm.feature.client.model;

import com.crm.feature.contact.model.Contact;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column
    @Enumerated(EnumType.STRING)
    private City city;
    @Column(nullable = false)
    private String website;
    @Column(nullable = false)
    private String description;
    @OneToMany (mappedBy = "client")
    private Set<Contact> contacts;

    public Client() {

    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Client(Long id, String name, City city, String website, String description, Set<Contact> contacts) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.website = website;
        this.description = description;
        this.contacts = contacts;
    }
    public Client(Long id, String name, City city, String website, String description) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.website = website;
        this.description = description;
    }
}
