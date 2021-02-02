package com.crm.feature.vacancy.service;

import com.crm.feature.client.model.Client;
import com.crm.feature.contact.model.Contact;
import com.crm.feature.vacancy.model.Vacancy;
import com.crm.feature.vacancy.repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VacancyService {

    @Autowired
    private VacancyRepository vacancyRepository;

    public List<Vacancy> getAll() {
        return vacancyRepository.findAll();
    }

    public Vacancy getById(Long id) {
        return vacancyRepository.findById(id).orElseThrow();
    }

    public void delete(Long id) {
        vacancyRepository.deleteById(id);
    }

    public void saveContact(final Vacancy vacancy) {
        vacancyRepository.save(vacancy);
    }

    public Vacancy updateContact(Long id, final Vacancy vacancy) {

        Optional<Vacancy> vacancyToUpdate = vacancyRepository.findById(id);
        Vacancy updatedVacancy = vacancyToUpdate.get();

        if (vacancyToUpdate.isPresent()) {
            updatedVacancy.setTitle(vacancy.getTitle());
            updatedVacancy.setDescription(vacancy.getDescription());
            updatedVacancy.setBudget(vacancy.getBudget());
            updatedVacancy.setBudgetType(vacancy.getBudgetType());
            updatedVacancy.setContractType(vacancy.getContractType());
            updatedVacancy.setCurrency(vacancy.getCurrency());
            updatedVacancy.setSkillTags(vacancy.getSkillTags());
            updatedVacancy.setContact(vacancy.getContact());
            updatedVacancy.setContact(vacancy.getContact());
            updatedVacancy = vacancyRepository.save(updatedVacancy);
        }
        return updatedVacancy;
    }



    public void updateStatus(Long id, final Vacancy vacancy) {

    }

    public List<Vacancy> getVacanciesByNameOfClient(String clientName) {
        return vacancyRepository.findByClientName(clientName);
    }

    public List<Vacancy> getVacanciesByIdOfCandidate(Long candidateId) {
        return vacancyRepository.findVacancyByCandidateId(candidateId);
    }


    public VacancyRepository getVacancyRepository() {
        return vacancyRepository;
    }

    public VacancyService(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }
}
