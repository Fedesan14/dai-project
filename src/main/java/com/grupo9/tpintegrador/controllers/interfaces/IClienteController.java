package com.grupo9.tpintegrador.controllers.interfaces;

import com.grupo9.tpintegrador.controllers.requests.clients.SaveClientRequest;
import com.grupo9.tpintegrador.data.models.Cliente;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/clients")
public interface IClienteController {

    @PostMapping
    @ResponseStatus(CREATED)
    Cliente createNewClient(@RequestBody SaveClientRequest request);

    @GetMapping
    @ResponseStatus(OK)

    Page<Cliente> getClients(
            @RequestParam(required = false) String dni,
            @RequestParam(required = false) String correo,
            @ParameterObject Pageable pageable
    );

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    Cliente getClientById(@PathVariable String id);

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    void deleteClientById(@PathVariable String id);



}
