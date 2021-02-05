package com.crm.feature.candidate.controller;

import com.crm.feature.candidate.model.Candidate;
import com.crm.feature.candidate.model.CandidateDTO;
import com.crm.feature.candidate.model.CandidateMapper;
import com.crm.feature.candidate.service.CandidateService;
import com.crm.feature.vacancy.model.Vacancy;
import com.crm.feature.vacancy.model.VacancyDTO;
import com.crm.feature.vacancy.model.VacancyMapper;
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
    @Autowired
    private CandidateMapper candidateMapper;
    @Autowired
    private VacancyMapper vacancyMapper;

    @GetMapping
    List<CandidateDTO> getAll(@RequestParam(required = false) String surname) {
        List<Candidate> candidates = new ArrayList<Candidate>();

        if (surname == null) {
            candidateService.getAll().forEach(candidates::add);
        } else {
            candidateService.getCandidatesBySurname(surname).forEach(candidates::add);
        }

        return candidateMapper.toCandidateDTOs(candidates);
    }

    @GetMapping("/{id}/vacancies")
    List<VacancyDTO> getVacanciesByCandidate(@PathVariable Long id) {
        List<Vacancy> vacancies = new ArrayList<Vacancy>();
        vacancyService.getVacanciesByIdOfCandidate(id).forEach(vacancies::add);
        return vacancyMapper.toVacancyDTOs(vacancies);
    }

    @GetMapping("/{id}")
    CandidateDTO getById(@PathVariable Long id) {
        return candidateMapper.toCandidateDTO(candidateService.getById(id));
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

    public CandidateController(CandidateService candidateService, VacancyService vacancyService, CandidateMapper candidateMapper, VacancyMapper vacancyMapper) {
        this.candidateService = candidateService;
        this.vacancyService = vacancyService;
        this.candidateMapper = candidateMapper;
        this.vacancyMapper = vacancyMapper;
    }

}
