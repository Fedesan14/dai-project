package com.grupo9.tpintegrador.services.interfaces;

import com.grupo9.tpintegrador.controllers.requests.states.SaveStateRequest;
import com.grupo9.tpintegrador.data.models.Estado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IEstadoService {

    Estado createNewState(@RequestBody SaveStateRequest request);
    Page<Estado> getStates(String nombre, Pageable pageable);
    Estado getStateById(@PathVariable String id);
    void deleteStateById(@PathVariable String id);
    Estado getCreatedState();
}
