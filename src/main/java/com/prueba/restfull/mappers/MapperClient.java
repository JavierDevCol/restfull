package com.prueba.restfull.mappers;

import com.prueba.restfull.entity.Client;
import com.prueba.restfull.model.ClientModel;
import org.springframework.stereotype.Component;

@Component
public class MapperClient {

    public Client toClient(ClientModel clientModel) {
        return new Client(
                clientModel.getDocumento(),
                clientModel.getTipoDocumneto(),
                clientModel.getNombreCompleto(),
                clientModel.getFechaNacimiento());
    }

    public ClientModel toClientModel(Client client) {
        return new ClientModel(
                client.getDocumento(),
                client.getTipoDocumento(),
                client.getNombreCompleto(),
                client.getFechaNacimiento().toString()
        );
    }
}
