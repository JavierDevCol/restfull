package com.prueba.restfull.service.impl;

import com.prueba.restfull.entity.Client;
import com.prueba.restfull.mappers.MapperClient;
import com.prueba.restfull.model.ClientModel;
import com.prueba.restfull.repository.RepositoryClient;
import com.prueba.restfull.service.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ServiceClientImpl implements ServiceClient {

    @Autowired
    private RepositoryClient repositoryClient;

    @Autowired
    private MapperClient mapperClient;

    @Override
    public Mono<ClientModel> findClienteByDocument(Long documento) {
        return this.repositoryClient.findByDocumento(documento)
                .map(mapperClient::toClientModel);
    }

    @Override
    public Mono<ClientModel> saveClient(ClientModel clientModel) {
        Client client = this.mapperClient.toClient(clientModel);
        return this.repositoryClient.save(client).map(mapperClient::toClientModel);
    }
}
