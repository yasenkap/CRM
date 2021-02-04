package com.crm.feature.contact.model;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    ContactDTO toContactDTO(Contact contact);

    List<ContactDTO> toContactDTOs(List<Contact> contacts);

    Contact toContact(ContactDTO contactDTO);
}