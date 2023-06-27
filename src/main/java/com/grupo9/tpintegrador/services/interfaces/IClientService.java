package com.grupo9.tpintegrador.services.interfaces;

import com.grupo9.tpintegrador.controllers.requests.clients.SaveClientRequest;
import com.grupo9.tpintegrador.data.models.Cliente;

import java.util.List;

public interface IClientService {

    Cliente createNewClient(SaveClientRequest request);
    List<Cliente> getClients();
    Cliente getClientById(String id);
    void deleteClientById(String id);

}
