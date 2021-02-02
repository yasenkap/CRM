package com.crm.feature.candidate.model;

import com.crm.feature.vacancy.model.Vacancy;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "candidates")
public class Candidate {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false, unique = true)
    @Email(message = "Invalid email")
    private String email;

    @Column
    private String description;

    @Column
    @ElementCollection
    private List<String> skillTags;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Candidate_Vacancy",
            joinColumns = { @JoinColumn(name = "candidate_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "vacancy_id", referencedColumnName = "id") }
    )
    private Set<Vacancy> vacancies = new HashSet<>();

    public Candidate() {

    }

    public Candidate(Long id, String name, String surname, String phoneNumber, @Email(message = "Invalid email") String email, String description, List<String> skillTags, Set<Vacancy> vacancies) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.description = description;
        this.skillTags = skillTags;
        this.vacancies = vacancies;
    }

    public Candidate(Long id, String name, String surname, String phoneNumber, @Email(message = "Invalid email") String email, String description, List<String> skillTags) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.description = description;
        this.skillTags = skillTags;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getSkillTags() {
        return skillTags;
    }

    public void setSkillTags(List<String> skillTags) {
        this.skillTags = skillTags;
    }

    public Set<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(Set<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }
}
