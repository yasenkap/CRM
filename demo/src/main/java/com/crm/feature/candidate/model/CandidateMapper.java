package com.crm.feature.candidate.model;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CandidateMapper {
    CandidateDTO toCandidateDTO(Candidate candidate);

    List<CandidateDTO> toCandidateDTOs(List<Candidate> candidates);

    Candidate toCandidate(CandidateDTO candidateDTO);
}
