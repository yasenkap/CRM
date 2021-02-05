package com.crm.feature.candidate.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-02-05T01:44:55+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.9 (Oracle Corporation)"
)
@Component
public class CandidateMapperImpl implements CandidateMapper {

    @Override
    public CandidateDTO toCandidateDTO(Candidate candidate) {
        if ( candidate == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String surname = null;
        String phoneNumber = null;
        String email = null;
        String description = null;
        List<String> skillTags = null;

        id = candidate.getId();
        name = candidate.getName();
        surname = candidate.getSurname();
        phoneNumber = candidate.getPhoneNumber();
        email = candidate.getEmail();
        description = candidate.getDescription();
        List<String> list = candidate.getSkillTags();
        if ( list != null ) {
            skillTags = new ArrayList<String>( list );
        }

        CandidateDTO candidateDTO = new CandidateDTO( id, name, surname, phoneNumber, email, description, skillTags );

        return candidateDTO;
    }

    @Override
    public List<CandidateDTO> toCandidateDTOs(List<Candidate> candidates) {
        if ( candidates == null ) {
            return null;
        }

        List<CandidateDTO> list = new ArrayList<CandidateDTO>( candidates.size() );
        for ( Candidate candidate : candidates ) {
            list.add( toCandidateDTO( candidate ) );
        }

        return list;
    }

    @Override
    public Candidate toCandidate(CandidateDTO candidateDTO) {
        if ( candidateDTO == null ) {
            return null;
        }

        Candidate candidate = new Candidate();

        candidate.setId( candidateDTO.getId() );
        candidate.setName( candidateDTO.getName() );
        candidate.setSurname( candidateDTO.getSurname() );
        candidate.setPhoneNumber( candidateDTO.getPhoneNumber() );
        candidate.setEmail( candidateDTO.getEmail() );
        candidate.setDescription( candidateDTO.getDescription() );
        List<String> list = candidateDTO.getSkillTags();
        if ( list != null ) {
            candidate.setSkillTags( new ArrayList<String>( list ) );
        }

        return candidate;
    }
}
