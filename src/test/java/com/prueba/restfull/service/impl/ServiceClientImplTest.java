package com.prueba.restfull.service.impl;

import com.prueba.restfull.entity.Client;
import com.prueba.restfull.errorDriver.personalizeException.ExceptionNombreInvalido;
import com.prueba.restfull.mappers.MapperClient;
import com.prueba.restfull.model.ClientModel;
import com.prueba.restfull.repository.RepositoryClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class ServiceClientImplTest {

    @Mock
    private RepositoryClient repositoryClient;

    @Mock
    private MapperClient mapperClient;

    @InjectMocks
    private ServiceClientImpl serviceClient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindClienteByDocument_Success() {
        Long documento = 123456789L;
        Client client = new Client(documento, "CEDULA", "Juan Perez", null);
        ClientModel clientModel = new ClientModel(documento, "DNI", "Juan Pérez", null);

        when(repositoryClient.findByDocumento(documento)).thenReturn(Mono.just(client));

        when(mapperClient.toClientModel(client)).thenReturn(clientModel);

        Mono<ClientModel> result = serviceClient.findClienteByDocument(documento);
        StepVerifier.create(result)
                .expectNextMatches(model -> model.getDocumento().equals(documento))
                .verifyComplete();
    }


}
