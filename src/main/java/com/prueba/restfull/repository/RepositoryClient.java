package com.prueba.restfull.repository;

import com.prueba.restfull.entity.Client;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface RepositoryClient extends ReactiveCrudRepository<Client, Long> {

    Mono<Client> findByDocumento(Long documento);
}
