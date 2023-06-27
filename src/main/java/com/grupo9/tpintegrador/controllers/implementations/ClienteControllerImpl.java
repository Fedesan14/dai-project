package com.grupo9.tpintegrador.controllers.implementations;

import com.grupo9.tpintegrador.controllers.interfaces.IClienteController;
import com.grupo9.tpintegrador.controllers.requests.clients.SaveClientRequest;
import com.grupo9.tpintegrador.data.models.Cliente;
import com.grupo9.tpintegrador.services.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClienteControllerImpl implements IClienteController {

    @Autowired
    IClientService clientService;

    @Override
    public Cliente createNewClient(SaveClientRequest request) {
        return clientService.createNewClient(request);
    }

    @Override
    public List<Cliente> getClients() {
        return clientService.getClients();
    }

    @Override
    public Cliente getClientById(String id) {
        return clientService.getClientById(id);
    }

    @Override
    public void deleteClientById(String id) {
        clientService.deleteClientById(id);
    }
}
