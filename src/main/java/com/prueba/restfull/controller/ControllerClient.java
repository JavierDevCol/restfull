package com.prueba.restfull.controller;

import com.prueba.restfull.model.ClientModel;
import com.prueba.restfull.service.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("client")
public class ControllerClient {

    @Autowired
    private ServiceClient serviceClient;

    @GetMapping("find-document/{documeto}")
    public Mono<ClientModel> findByDocument(@PathVariable("documeto") Long documento) {
        return serviceClient.findClienteByDocument(documento);
    }

    @PostMapping()
    public Mono<ClientModel> guardarCliente(@RequestBody ClientModel cliente) {
        return serviceClient.saveClient(cliente);
    }
}
