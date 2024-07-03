package com.prueba.restfull.service.impl;

import com.prueba.restfull.entity.Client;
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
    void testFindClienteByDocument() {
        // Datos de prueba
        Long documento = 123456789L;
        Client client = new Client(documento, "DNI", "Juan Pérez", null);
        ClientModel clientModel = new ClientModel(documento, "DNI", "Juan Pérez", null);

        // Mock del repositorio
        when(repositoryClient.findByDocumento(documento)).thenReturn(Mono.just(client));

        // Mock del mapper
        when(mapperClient.toClientModel(client)).thenReturn(clientModel);

        // Ejecutar el método del servicio y verificar el resultado
        Mono<ClientModel> result = serviceClient.findClienteByDocument(documento);
        StepVerifier.create(result)
                .expectNextMatches(model -> model.getDocumento().equals(documento))
                .verifyComplete();
    }

    // Otras pruebas para saveClient y otros métodos del servicio pueden ser agregadas aquí
}
