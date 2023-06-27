package com.grupo9.tpintegrador.controllers.interfaces;

import com.grupo9.tpintegrador.controllers.requests.espacios.EspacioFisicoRequest;
import com.grupo9.tpintegrador.data.models.EspacioFisico;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/espacios")
public interface IEspacioFisicoController {

    @PostMapping
    @ResponseStatus(CREATED)
    EspacioFisico saveEspacioFisico(@RequestBody EspacioFisicoRequest request);

    @GetMapping(params = {"page","size"})
    @ResponseStatus(OK)
    Page<EspacioFisico> getEspaciosFisicos(@RequestParam("page") int page,
                                           @RequestParam("size") int size);

    @GetMapping(params = {"nombre","capacidad","page","size"})
    @ResponseStatus(OK)
    Page<EspacioFisico> getEspaciosFisicosByNombreAndCapacidad(@RequestParam("nombre") String nombre,
                                                               @RequestParam("capacidad") int capacidad,
                                                               @RequestParam("page") int page,
                                                               @RequestParam("size") int size);
    @GetMapping(params = {"nombre","page","size"})
    @ResponseStatus(OK)
    Page<EspacioFisico> getEspaciosFisicosByNombre(@RequestParam("nombre") String nombre,
                                                               @RequestParam("page") int page,
                                                               @RequestParam("size") int size);
    @GetMapping(params = {"capacidad","page","size"})
    @ResponseStatus(OK)
    Page<EspacioFisico> getEspaciosFisicosByCapacidad(@RequestParam("capacidad") int capacidad,
                                                               @RequestParam("page") int page,
                                                               @RequestParam("size") int size);
    @GetMapping("/{id}")
    @ResponseStatus(OK)
    EspacioFisico getEspacioFisico(@PathVariable String id);

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    void deleteEspacioFisico(@PathVariable String id);

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    EspacioFisico updateEspacioFisico(@RequestBody EspacioFisicoRequest request, @PathVariable String id);

    @PostMapping("/{espacioId}/{recursoId}")
    @ResponseStatus(OK)
    void addRecurso(@PathVariable String espacioId, @PathVariable String recursoId);

    @DeleteMapping("/{espacioId}/{recursoId}")
    @ResponseStatus(OK)
    void removeRecurso(@PathVariable String espacioId, @PathVariable String recursoId);
}
