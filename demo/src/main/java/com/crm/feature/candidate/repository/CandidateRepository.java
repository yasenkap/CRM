package com.crm.feature.candidate.repository;

import com.crm.feature.candidate.model.Candidate;
import com.crm.feature.client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    @Query("select c from Candidate c join c.vacancies v where v.id = : vacancyId ")
    List<Candidate> findCandidatesByVacancyId(@Param("vacancyId") Long vacancyId);

    @Query("select c from Candidate c where c.surname like %:surname%")
    List<Candidate> findBySurnameLike(@Param("surname") String surname);

}
