package com.grupo9.tpintegrador.controllers.implementations;

import com.grupo9.tpintegrador.controllers.interfaces.IEstadoController;
import com.grupo9.tpintegrador.controllers.requests.states.SaveStateRequest;
import com.grupo9.tpintegrador.data.models.Estado;
import com.grupo9.tpintegrador.services.interfaces.IEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EstadoControllerImpl implements IEstadoController {

    @Autowired
    IEstadoService estadoService;

    @Override
    public Estado createNewState(SaveStateRequest request) {
        return estadoService.createNewState(request);
    }

    @Override
    public Page<Estado> getStates(String nombre, Pageable pageable) {
        return estadoService.getStates(nombre, pageable);
    }


    @Override
    public Estado getStateById(String id) {
        return estadoService.getStateById(id);
    }

    @Override
    public void deleteStateById(String id) {
        estadoService.deleteStateById(id);
    }
}
