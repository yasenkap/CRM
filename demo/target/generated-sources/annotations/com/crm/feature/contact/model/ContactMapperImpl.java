package com.crm.feature.contact.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-02-05T00:14:16+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.9 (Oracle Corporation)"
)
@Component
public class ContactMapperImpl implements ContactMapper {

    @Override
    public ContactDTO toContactDTO(Contact contact) {
        if ( contact == null ) {
            return null;
        }

        String name = null;
        String surname = null;
        String position = null;
        String email = null;
        String phoneNumber = null;

        name = contact.getName();
        surname = contact.getSurname();
        position = contact.getPosition();
        email = contact.getEmail();
        phoneNumber = contact.getPhoneNumber();

        ContactDTO contactDTO = new ContactDTO( name, surname, position, email, phoneNumber );

        return contactDTO;
    }

    @Override
    public List<ContactDTO> toContactDTOs(List<Contact> contacts) {
        if ( contacts == null ) {
            return null;
        }

        List<ContactDTO> list = new ArrayList<ContactDTO>( contacts.size() );
        for ( Contact contact : contacts ) {
            list.add( toContactDTO( contact ) );
        }

        return list;
    }

    @Override
    public Contact toContact(ContactDTO contactDTO) {
        if ( contactDTO == null ) {
            return null;
        }

        Contact contact = new Contact();

        contact.setName( contactDTO.getName() );
        contact.setSurname( contactDTO.getSurname() );
        contact.setEmail( contactDTO.getEmail() );
        contact.setPhoneNumber( contactDTO.getPhoneNumber() );
        contact.setPosition( contactDTO.getPosition() );

        return contact;
    }
}
