package com.crm.feature.client.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-02-05T00:54:10+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.9 (Oracle Corporation)"
)
*/
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientDTO toClientDTO(Client client) {
        if ( client == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        City city = null;
        String website = null;
        String description = null;

        id = client.getId();
        name = client.getName();
        city = client.getCity();
        website = client.getWebsite();
        description = client.getDescription();

        ClientDTO clientDTO = new ClientDTO( id, name, city, website, description );

        return clientDTO;
    }

    @Override
    public List<ClientDTO> toClientDTOs(List<Client> clients) {
        if ( clients == null ) {
            return null;
        }

        List<ClientDTO> list = new ArrayList<ClientDTO>( clients.size() );
        for ( Client client : clients ) {
            list.add( toClientDTO( client ) );
        }

        return list;
    }

    @Override
    public Client toClient(ClientDTO clientDTO) {
        if ( clientDTO == null ) {
            return null;
        }

        Client client = new Client();

        client.setId( clientDTO.getId() );
        client.setCity( clientDTO.getCity() );
        client.setWebsite( clientDTO.getWebsite() );
        client.setDescription( clientDTO.getDescription() );
        client.setName( clientDTO.getName() );

        return client;
    }
}
