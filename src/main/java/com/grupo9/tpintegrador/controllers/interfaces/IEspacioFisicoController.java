package com.grupo9.tpintegrador.controllers.interfaces;

import com.grupo9.tpintegrador.data.models.EspacioFisico;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/espacios")
public interface IEspacioFisicoController {

    @PostMapping
    @ResponseStatus(CREATED)
    EspacioFisico saveEspacioFisico(@RequestBody EspacioFisico espacioFisico);

    @GetMapping
    @ResponseStatus(OK)
    List<EspacioFisico> getEspaciosFisicos();

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    EspacioFisico getEspacioFisico(@PathVariable String id);

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    String deleteEspacioFisico(@PathVariable String id);

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    EspacioFisico updateEspacioFisico(@RequestBody EspacioFisico espacioFisico, @PathVariable String id);

}
