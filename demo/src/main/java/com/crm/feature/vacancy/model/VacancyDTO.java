package com.crm.feature.vacancy.model;

import java.util.List;

public class VacancyDTO {

    private Long id;
    private String title;
    private double budget;
    private BudgetType budgetType;
    private Currency currency;
    private ContractType contractType;
    private String description;
    private List<String> skillTags;

    public VacancyDTO(Long id, String title, double budget, BudgetType budgetType, Currency currency, ContractType contractType, String description, List<String> skillTags) {
        this.id = id;
        this.title = title;
        this.budget = budget;
        this.budgetType = budgetType;
        this.currency = currency;
        this.contractType = contractType;
        this.description = description;
        this.skillTags = skillTags;
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

    public List<String> getSkillTags() {
        return skillTags;
    }

    public void setSkillTags(List<String> skillTags) {
        this.skillTags = skillTags;
    }
}
