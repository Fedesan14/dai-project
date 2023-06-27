package com.grupo9.tpintegrador.controllers.implementations;

import com.grupo9.tpintegrador.controllers.interfaces.IRecursoTecnologicoController;
import com.grupo9.tpintegrador.data.models.RecursoTecnologico;
import com.grupo9.tpintegrador.services.interfaces.IRecursoTecnologicoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<RecursoTecnologico> getRecursosTecnologicos() {
        return recursoTecnologicoService.getRecursosTecnologicos();
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
    public String deleteRecursoTecnologico(String id) {
        return recursoTecnologicoService.deleteRecursoTecnologico(id);
    }

    @Override
    public RecursoTecnologico updateRecursoTecnologico(RecursoTecnologico recursoTecnologico, String id) {
        return recursoTecnologicoService.updateRecursoTecnologico(recursoTecnologico, id);
    }

}
