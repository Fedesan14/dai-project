package com.grupo9.tpintegrador.controllers.implementations;

import com.grupo9.tpintegrador.controllers.interfaces.IRecursoTecnologicoController;
import com.grupo9.tpintegrador.data.models.RecursoTecnologico;
import com.grupo9.tpintegrador.services.interfaces.IRecursoTecnologicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class RecursoTecnologicoController implements IRecursoTecnologicoController {

    @Autowired
    IRecursoTecnologicoService recursoTecnologicoService;

    @Override
    public RecursoTecnologico saveRecursoTecnologico(RecursoTecnologico recursoTecnologico) {
        return recursoTecnologicoService.saveRecursoTecnologico(recursoTecnologico);
    }

    @Override
    public Page<RecursoTecnologico> getRecursosTecnologicos(
            String nombre,
            Pageable pageable
    ) {
        return recursoTecnologicoService.getRecursosTecnologicos(nombre, pageable);
    }

    @Override
    public RecursoTecnologico getRecursoTecnologico(String id) {
        return recursoTecnologicoService.getRecursoTecnologico(id);
    }

    @Override
    public Iterable<RecursoTecnologico> getFiltroNombre(String nombre) {
        return this.recursoTecnologicoService.getFiltroNombre(nombre);
    }

    @Override
    public void deleteRecursoTecnologico(String id) {
        recursoTecnologicoService.deleteRecursoTecnologico(id);
    }

    @Override
    public RecursoTecnologico updateRecursoTecnologico(RecursoTecnologico recursoTecnologico, String id) {
        return recursoTecnologicoService.updateRecursoTecnologico(recursoTecnologico, id);
    }

}
