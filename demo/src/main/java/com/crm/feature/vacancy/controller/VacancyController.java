package com.crm.feature.vacancy.controller;

import com.crm.feature.candidate.model.Candidate;
import com.crm.feature.candidate.service.CandidateService;
import com.crm.feature.contact.model.Contact;
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
@RequestMapping("/vacancies")
public class VacancyController {

    @Autowired
    private VacancyService vacancyService;
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private VacancyMapper vacancyMapper;

    @GetMapping
    List<VacancyDTO> getAll(@RequestParam(required = false) String clientName) {
        List<Vacancy> vacancies = new ArrayList<>();

        if (clientName == null) {
            vacancyService.getAll().forEach(vacancies::add);
        } else {
            vacancyService.getVacanciesByNameOfClient(clientName).forEach(vacancies::add);
        }
        return vacancyMapper.toVacancyDTOs(vacancies);
    }

    @GetMapping("/{id}/candidates")
    List<Candidate> getCandidatesByVacancyId(@PathVariable Long id) {
        List<Candidate> candidates = new ArrayList<>();
        candidateService.getCandidatesByVacancyId(id).forEach(candidates::add);
        return candidates;
    }

    @GetMapping("/{id}")
    VacancyDTO getById(@PathVariable Long id) {
        return vacancyMapper.toVacancyDTO(vacancyService.getById(id));
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        vacancyService.delete(id);
    }

    @PostMapping
    public void saveVacancy(@RequestBody final Vacancy vacancy) {
        vacancyService.saveContact(vacancy);
    }

    @PutMapping("/{id}")
    public Vacancy updateVacancy(@PathVariable("id") long id, @RequestBody final Vacancy vacancy) {
        return vacancyService.updateContact(id, vacancy);
    }

    public VacancyService getVacancyService() {
        return vacancyService;
    }

    public CandidateService getCandidateService() {
        return candidateService;
    }

    public VacancyController(VacancyService vacancyService, CandidateService candidateService, VacancyMapper vacancyMapper) {
        this.vacancyService = vacancyService;
        this.candidateService = candidateService;
        this.vacancyMapper = vacancyMapper;
    }
}
