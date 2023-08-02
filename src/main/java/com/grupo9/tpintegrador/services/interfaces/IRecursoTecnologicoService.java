package com.grupo9.tpintegrador.services.interfaces;

import com.grupo9.tpintegrador.data.models.RecursoTecnologico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IRecursoTecnologicoService {
    RecursoTecnologico saveRecursoTecnologico(RecursoTecnologico recursoTecnologico);

    Page<RecursoTecnologico> getRecursosTecnologicos(String nombre, Pageable pageable);

    void deleteRecursoTecnologico(String id);

    RecursoTecnologico updateRecursoTecnologico(RecursoTecnologico recursoTecnologico, String id);

    RecursoTecnologico getRecursoTecnologico(String id);


    Iterable<RecursoTecnologico> getFiltroNombre(String nombre);
}
