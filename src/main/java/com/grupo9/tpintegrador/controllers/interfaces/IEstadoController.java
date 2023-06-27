package com.grupo9.tpintegrador.controllers.interfaces;

import com.grupo9.tpintegrador.controllers.requests.clients.SaveClientRequest;
import com.grupo9.tpintegrador.controllers.requests.states.SaveStateRequest;
import com.grupo9.tpintegrador.data.models.Estado;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/states")
public interface IEstadoController {
    @PostMapping
    @ResponseStatus(CREATED)
    Estado createNewState(@RequestBody SaveStateRequest request);

    @GetMapping
    @ResponseStatus(OK)
    List<Estado> getStates();

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    Estado getStateById(@PathVariable String id);

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    void deleteStateById(@PathVariable String id);

}
