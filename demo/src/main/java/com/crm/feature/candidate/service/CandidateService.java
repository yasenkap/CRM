package com.crm.feature.candidate.service;

import com.crm.feature.candidate.model.Candidate;
import com.crm.feature.candidate.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public List<Candidate> getAll() {
        return candidateRepository.findAll();
    }

    public Candidate getById(Long id) {
        return candidateRepository.findById(id).orElseThrow();
    }

    public void delete(Long id) {
        candidateRepository.deleteById(id);
    }

    public void saveCandidate(final Candidate candidate) {
        candidateRepository.save(candidate);
    }

    public Candidate updateCandidate(Long id, final Candidate candidate) {

        Optional<Candidate> candidateToUpdate = candidateRepository.findById(id);
        Candidate updatedCandidate = candidateToUpdate.get();

        if (candidateToUpdate.isPresent()) {
            updatedCandidate.setName(candidate.getName());
            updatedCandidate.setSurname(candidate.getSurname());
            updatedCandidate.setEmail(candidate.getEmail());
            updatedCandidate.setDescription(candidate.getDescription());
            updatedCandidate.setSkillTags(candidate.getSkillTags());
            updatedCandidate.setVacancies(candidate.getVacancies());
            updatedCandidate = candidateRepository.save(updatedCandidate);
        }
        return updatedCandidate;
    }

    public List<Candidate> getCandidatesByVacancyId(Long vacancyId) {
        return candidateRepository.findCandidatesByVacancyId(vacancyId);
    }

    public List<Candidate> getCandidatesBySurname(String surname) {
        return candidateRepository.findBySurnameLike(surname);
    }

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }
}
