package com.grupo9.tpintegrador.services.implementations;

import com.grupo9.tpintegrador.controllers.requests.clients.SaveClientRequest;
import com.grupo9.tpintegrador.controllers.responses.clientes.ClienteDTO;
import com.grupo9.tpintegrador.data.models.Cliente;
import com.grupo9.tpintegrador.data.repositories.IClienteRepository;
import com.grupo9.tpintegrador.services.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements IClientService {

    @Autowired
    IClienteRepository clienteRepository;

    @Override
    public Cliente createNewClient(SaveClientRequest request) {

        if(clienteRepository.findByDni(request.getDni()).isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El dni del cliente ingresado ya existe");
        }

       return clienteRepository.save(new Cliente(
                request.getNombre(),
                request.getApellido(),
                request.getDni(),
                request.getEmail(),
                request.getNroTelefono()
        ));
    }

    @Override
    public Page<ClienteDTO> getClients(String dni, String correo, Pageable pageable) {
        return buildClienteDTO(clienteRepository.findByDniAndEmail(dni, correo, pageable));
    }

    private Page<ClienteDTO> buildClienteDTO(Page<Cliente> clientes) {
        List<ClienteDTO> clientesDTO = clientes.stream().map(
                cliente -> new ClienteDTO(
                        cliente.getId().toString(),
                        cliente.getNombre(),
                        cliente.getApellido()
                )
        ).collect(Collectors.toList());
        return new PageImpl<>(clientesDTO, clientes.getPageable(), clientes.getTotalElements());
    }

    @Override
    public Cliente getClientById(String id) {
        return clienteRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "El cliente ingresado no existe"));
    }

    @Override
    public void deleteClientById(String id) {
        Cliente clientToDelete = clienteRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "El cliente ingresado no existe"));

        clienteRepository.delete(clientToDelete);
    }
}
