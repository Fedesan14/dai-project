package com.grupo9.tpintegrador.services.implementations;

import com.grupo9.tpintegrador.controllers.requests.states.SaveStateRequest;
import com.grupo9.tpintegrador.data.models.Estado;
import com.grupo9.tpintegrador.data.repositories.IEstadoRepository;
import com.grupo9.tpintegrador.services.interfaces.IEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class EstadoServiceImpl implements IEstadoService {

    @Autowired
    IEstadoRepository estadoRepository;

    @Override
    public Estado createNewState(SaveStateRequest request) {

        if(estadoRepository.existsByNombre(request.getNombre())){
            throw new ResponseStatusException(BAD_REQUEST, "Ya existe un estado con ese nombre");
        }

        return estadoRepository.save(new Estado(
                request.getNombre(),
                request.getDescripcion()
        ));
    }

    @Override
    public List<Estado> getStates() {
        return estadoRepository.findAll();
    }

    @Override
    public Estado getStateById(String id) {
        return estadoRepository.findById(UUID.fromString(id))
                .orElseThrow( () -> new ResponseStatusException(NOT_FOUND, "No existe un estado para el id ingresado " + id));
    }

    @Override
    public void deleteStateById(String id) {
        Estado stateToDeleted = estadoRepository.findById(UUID.fromString(id))
                .orElseThrow( () -> new ResponseStatusException(NOT_FOUND, "No existe un estado para el id ingresado " + id));

        estadoRepository.delete(stateToDeleted);
    }

    @Override
    public Estado getCreatedState() {
        return estadoRepository.findByNombre("CREADO")
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "No existe el estado CREADO para la reserva."));
    }
}
