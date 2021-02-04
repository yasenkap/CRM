package com.crm.feature.client.model;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDTO toClientDTO(Client client);

    List<ClientDTO> toClientDTOs(List<Client> clients);

    Client toClient(ClientDTO clientDTO);
}
