package com.prueba.restfull.service;

import com.prueba.restfull.model.ClientModel;
import reactor.core.publisher.Mono;

public interface ServiceClient {

    Mono<ClientModel> findClienteByDocument(Long documento);

    Mono<ClientModel> saveClient(ClientModel clientModel);


}
