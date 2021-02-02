package com.crm.feature.vacancy.repository;

import com.crm.feature.vacancy.model.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {

    @Query("select v from Vacancy v where v.client.name = :clientName")
    List<Vacancy> findByClientName(@Param("clientName") String clientName);

    @Query("select v from Vacancy v join v.candidates c where c.id  = :candidateId")
    List<Vacancy> findVacancyByCandidateId(@Param("candidateId") Long candidateId);

}
