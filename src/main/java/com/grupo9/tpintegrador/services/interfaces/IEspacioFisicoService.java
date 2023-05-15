package com.grupo9.tpintegrador.services.interfaces;

import com.grupo9.tpintegrador.controllers.requests.espacios.SaveEspacioFisicoRequest;
import com.grupo9.tpintegrador.data.models.EspacioFisico;

import java.util.List;

public interface IEspacioFisicoService {
    EspacioFisico saveEspacioFisico(SaveEspacioFisicoRequest request);

    List<EspacioFisico> getEspaciosFisicos();

    String deleteEspacioFisico(String id);

    EspacioFisico updateEspacioFisico(EspacioFisico espacioFisico, String id);

    EspacioFisico getEspacioFisico(String id);

    void addRecurso(String espacioId, String recursoId);
    void removeRecurso(String espacioId, String recursoId);
}
