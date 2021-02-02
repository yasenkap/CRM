package com.crm.feature.vacancy.model;

import com.crm.feature.candidate.model.Candidate;
import com.crm.feature.client.model.Client;
import com.crm.feature.contact.model.Contact;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// to do: add file with job description

@Entity
@Table(name = "vacancies")
public class Vacancy {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private double budget;
    @Column
    @Enumerated(EnumType.STRING)
    private BudgetType budgetType;
    @Column
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @Column
    @Enumerated(EnumType.STRING)
    private ContractType contractType;
    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name="contact_id")
    private Contact contact;
    // nullable=false

    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;
// nullable=false

    @ManyToMany(mappedBy = "vacancies")
    private Set<Candidate> candidates = new HashSet<>();

    @Column
    @ElementCollection
    private List<String> skillTags;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status = Status.NOT_ACTIVE;


    public Vacancy(){

    }

    public Vacancy(Long id, String title, double budget, BudgetType budgetType, Currency currency, ContractType contractType, String description, Contact contact, Client client, Set<Candidate> candidates, List<String> skillTags, Status status) {
        this.id = id;
        this.title = title;
        this.budget = budget;
        this.budgetType = budgetType;
        this.currency = currency;
        this.contractType = contractType;
        this.description = description;
        this.contact = contact;
        this.client = client;
        this.candidates = candidates;
        this.skillTags = skillTags;
        this.status = status;
    }

    public Vacancy(Long id, String title, double budget, BudgetType budgetType, Currency currency, ContractType contractType, String description, List<String> skillTags, Status status) {
        this.id = id;
        this.title = title;
        this.budget = budget;
        this.budgetType = budgetType;
        this.currency = currency;
        this.contractType = contractType;
        this.description = description;
        this.skillTags = skillTags;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public BudgetType getBudgetType() {
        return budgetType;
    }

    public void setBudgetType(BudgetType budgetType) {
        this.budgetType = budgetType;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<String> getSkillTags() {
        return skillTags;
    }

    public void setSkillTags(List<String> skillTags) {
        this.skillTags = skillTags;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<Candidate> getCandidate() {
        return candidates;
    }

    public void setCandidate(Set<Candidate> candidates) {
        this.candidates = candidates;
    }
}
