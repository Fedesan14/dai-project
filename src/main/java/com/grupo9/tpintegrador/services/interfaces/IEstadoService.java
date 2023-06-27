package com.grupo9.tpintegrador.services.interfaces;

import com.grupo9.tpintegrador.controllers.requests.states.SaveStateRequest;
import com.grupo9.tpintegrador.data.models.Estado;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IEstadoService {

    Estado createNewState(@RequestBody SaveStateRequest request);
    List<Estado> getStates();
    Estado getStateById(@PathVariable String id);
    void deleteStateById(@PathVariable String id);
    Estado getCreatedState();
}
