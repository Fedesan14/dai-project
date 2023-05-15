package com.grupo9.tpintegrador.services.interfaces;

import com.grupo9.tpintegrador.data.models.RecursoTecnologico;

import java.util.List;

public interface IRecursoTecnologicoService {
    RecursoTecnologico saveRecursoTecnologico(RecursoTecnologico recursoTecnologico);

    List<RecursoTecnologico> getRecursosTecnologicos();

    String deleteRecursoTecnologico(String id);

    RecursoTecnologico updateRecursoTecnologico(RecursoTecnologico recursoTecnologico, String id);

    RecursoTecnologico getRecursoTecnologico(String id);


}
