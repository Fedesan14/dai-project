package com.grupo9.tpintegrador.services.interfaces;

import com.grupo9.tpintegrador.controllers.requests.clients.SaveClientRequest;
import com.grupo9.tpintegrador.controllers.responses.clientes.ClienteDTO;
import com.grupo9.tpintegrador.data.models.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IClientService {

    Cliente createNewClient(SaveClientRequest request);
    Page<ClienteDTO> getClients(String dni, String correo, Pageable pageable);
    Cliente getClientById(String id);
    void deleteClientById(String id);

}
