package com.crm.feature.vacancy.model;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VacancyMapper {

    VacancyDTO toVacancyDTO(Vacancy vacancy);

    List<VacancyDTO> toVacancyDTOs(List<Vacancy> vacancies);

    Vacancy toVacancy(VacancyDTO vacancyDTO);
}
