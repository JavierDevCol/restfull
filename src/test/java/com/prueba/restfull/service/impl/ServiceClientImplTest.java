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

import java.time.LocalDate;

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
    void testFindClienteByDocument_ClienteEncontrado() {
        Long documento = 123456789L;
        Client client = new Client(documento, "CEDULA", "Juan Perez", null);
        ClientModel clientModel = new ClientModel(documento, "CEDULA", "Juan Perez", null);

        when(repositoryClient.findByDocumento(documento))
                .thenReturn(Mono.just(client));

        when(mapperClient.toClientModel(client)).thenReturn(clientModel);

        Mono<ClientModel> result = serviceClient.findClienteByDocument(documento);
        StepVerifier.create(result)
                .expectNext(clientModel)
                .verifyComplete();
    }

    @Test
    void testFindClienteByDocument_ClienteNoEncontrado() {
        Long documento = 987654321L;

        when(repositoryClient.findByDocumento(documento))
                .thenReturn(Mono.empty());

        Mono<ClientModel> result = serviceClient.findClienteByDocument(documento);
        StepVerifier.create(result)
                .expectNextCount(0)
                .verifyComplete();
    }

    @Test
    void testFindClienteByDocument_ErrorNombreInvalido() {
        Long documento = 123456789L;

        when(repositoryClient.findByDocumento(documento))
                .thenReturn(Mono.error(new ExceptionNombreInvalido("Nombre no válido")));

        Mono<ClientModel> result = serviceClient.findClienteByDocument(documento);
        StepVerifier.create(result)
                .expectErrorMatches(throwable -> throwable instanceof ExceptionNombreInvalido &&
                        throwable.getMessage().equals("Nombre no válido"))
                .verify();
    }


}
