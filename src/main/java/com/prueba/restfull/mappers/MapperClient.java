package com.prueba.restfull.mappers;

import com.prueba.restfull.entity.Client;
import com.prueba.restfull.model.ClientModel;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class MapperClient {

    public Client toClient(ClientModel clientModel) {
        return new Client(
                clientModel.getDocumento(),
                clientModel.getTipoDocumneto(),
                clientModel.getNombreCompleto(),
                LocalDate.parse(clientModel.getFechaNacimiento(), DateTimeFormatter.ISO_LOCAL_DATE));
    }

    public ClientModel toClientModel(Client client) {
        return new ClientModel(
                client.getDocumento(),
                client.getTipoDocumento(),
                client.getNombreCompleto(),
                client.getFechaNacimiento() != null? client.getFechaNacimiento().toString() : null
        );
    }
}
