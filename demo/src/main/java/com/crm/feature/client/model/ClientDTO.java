package com.crm.feature.client.model;


public class ClientDTO {

    private Long id;
    private String name;
    private City city;
    private String website;
    private String description;

    public ClientDTO(Long id, String name, City city, String website, String description) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.website = website;
        this.description = description;
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
}
