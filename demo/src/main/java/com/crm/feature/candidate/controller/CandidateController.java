package com.crm.feature.candidate.controller;

import com.crm.feature.candidate.model.Candidate;
import com.crm.feature.candidate.service.CandidateService;
import com.crm.feature.vacancy.model.Vacancy;
import com.crm.feature.vacancy.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private VacancyService vacancyService;

    @GetMapping
    List<Candidate> getAll(@RequestParam(required = false) String surname) {
        List<Candidate> candidates = new ArrayList<Candidate>();

        if (surname == null) {
            candidateService.getAll().forEach(candidates::add);
        } else {
            candidateService.getCandidatesBySurname(surname).forEach(candidates::add);
        }

        return candidates;
    }

    @GetMapping("/{id}/vacancies")
    List<Vacancy> getVacanciesByCandidate(@PathVariable Long id) {
        List<Vacancy> vacancies = new ArrayList<Vacancy>();
        vacancyService.getVacanciesByIdOfCandidate(id).forEach(vacancies::add);
        return vacancies;
    }

    @GetMapping("/{id}")
    Candidate getById(@PathVariable Long id) {
        return candidateService.getById(id);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        candidateService.delete(id);
    }

    @PostMapping
    public void saveCandidate(@RequestBody final Candidate candidate) {
        candidateService.saveCandidate(candidate);
    }

    @PutMapping("/{id}")
    public Candidate updateVacancy(@PathVariable("id") long id, @RequestBody final Candidate candidate) {
        return candidateService.updateCandidate(id, candidate);
    }

    public CandidateController(CandidateService candidateService, VacancyService vacancyService) {
        this.candidateService = candidateService;
        this.vacancyService = vacancyService;
    }

}
