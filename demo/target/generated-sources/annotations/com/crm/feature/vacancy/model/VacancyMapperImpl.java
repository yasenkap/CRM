package com.crm.feature.vacancy.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-02-05T01:44:56+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.9 (Oracle Corporation)"
)
@Component
public class VacancyMapperImpl implements VacancyMapper {

    @Override
    public VacancyDTO toVacancyDTO(Vacancy vacancy) {
        if ( vacancy == null ) {
            return null;
        }

        Long id = null;
        String title = null;
        double budget = 0.0d;
        BudgetType budgetType = null;
        Currency currency = null;
        ContractType contractType = null;
        String description = null;
        List<String> skillTags = null;

        id = vacancy.getId();
        title = vacancy.getTitle();
        budget = vacancy.getBudget();
        budgetType = vacancy.getBudgetType();
        currency = vacancy.getCurrency();
        contractType = vacancy.getContractType();
        description = vacancy.getDescription();
        List<String> list = vacancy.getSkillTags();
        if ( list != null ) {
            skillTags = new ArrayList<String>( list );
        }

        VacancyDTO vacancyDTO = new VacancyDTO( id, title, budget, budgetType, currency, contractType, description, skillTags );

        return vacancyDTO;
    }

    @Override
    public List<VacancyDTO> toVacancyDTOs(List<Vacancy> vacancies) {
        if ( vacancies == null ) {
            return null;
        }

        List<VacancyDTO> list = new ArrayList<VacancyDTO>( vacancies.size() );
        for ( Vacancy vacancy : vacancies ) {
            list.add( toVacancyDTO( vacancy ) );
        }

        return list;
    }

    @Override
    public Vacancy toVacancy(VacancyDTO vacancyDTO) {
        if ( vacancyDTO == null ) {
            return null;
        }

        Vacancy vacancy = new Vacancy();

        vacancy.setId( vacancyDTO.getId() );
        vacancy.setTitle( vacancyDTO.getTitle() );
        vacancy.setBudget( vacancyDTO.getBudget() );
        vacancy.setBudgetType( vacancyDTO.getBudgetType() );
        vacancy.setCurrency( vacancyDTO.getCurrency() );
        vacancy.setContractType( vacancyDTO.getContractType() );
        vacancy.setDescription( vacancyDTO.getDescription() );
        List<String> list = vacancyDTO.getSkillTags();
        if ( list != null ) {
            vacancy.setSkillTags( new ArrayList<String>( list ) );
        }

        return vacancy;
    }
}
