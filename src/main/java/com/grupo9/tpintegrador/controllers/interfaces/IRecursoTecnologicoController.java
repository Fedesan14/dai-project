package com.grupo9.tpintegrador.controllers.interfaces;

import com.grupo9.tpintegrador.data.models.RecursoTecnologico;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/recursos")
public interface IRecursoTecnologicoController {

    @PostMapping
    @ResponseStatus(CREATED)
    RecursoTecnologico saveRecursoTecnologico(@RequestBody RecursoTecnologico recursoTecnologico);

    @GetMapping
    @ResponseStatus(OK)
    List<RecursoTecnologico> getRecursosTecnologicos();

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    RecursoTecnologico getRecursoTecnologico(@PathVariable String id);

    @GetMapping(value = "/search",params = {"nombre"})
    Iterable<RecursoTecnologico> getFiltroNombre(@RequestParam(name = "nombre", required = true)
    String nombre);

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    String deleteRecursoTecnologico(@PathVariable String id);

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    RecursoTecnologico updateRecursoTecnologico(@RequestBody RecursoTecnologico recursoTecnologico, @PathVariable String id);

}
