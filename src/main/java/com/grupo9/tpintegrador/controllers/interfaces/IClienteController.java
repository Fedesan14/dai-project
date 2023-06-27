package com.grupo9.tpintegrador.controllers.interfaces;

import com.grupo9.tpintegrador.controllers.requests.clients.SaveClientRequest;
import com.grupo9.tpintegrador.data.models.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/clients")
public interface IClienteController {

    @PostMapping
    @ResponseStatus(CREATED)
    Cliente createNewClient(@RequestBody SaveClientRequest request);

    @GetMapping
    @ResponseStatus(OK)
    List<Cliente> getClients();

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    Cliente getClientById(@PathVariable String id);

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    void deleteClientById(@PathVariable String id);



}
