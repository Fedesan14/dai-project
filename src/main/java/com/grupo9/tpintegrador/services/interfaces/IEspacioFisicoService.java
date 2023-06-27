package com.grupo9.tpintegrador.services.interfaces;

import com.grupo9.tpintegrador.controllers.requests.espacios.EspacioFisicoRequest;
import com.grupo9.tpintegrador.data.models.EspacioFisico;
import org.springframework.data.domain.Page;

public interface IEspacioFisicoService {
    EspacioFisico saveEspacioFisico(EspacioFisicoRequest request);

    Page<EspacioFisico> getEspaciosFisicos(int page, int size);

    void deleteEspacioFisico(String id);

    EspacioFisico updateEspacioFisico(EspacioFisicoRequest request, String id);

    EspacioFisico getEspacioFisico(String id);

    void addRecurso(String espacioId, String recursoId);
    void removeRecurso(String espacioId, String recursoId);

    Page<EspacioFisico> getEspaciosFisicosByNombreAndCapacidad(String nombre, int capacidad, int page, int size);
    Page<EspacioFisico> getEspaciosFisicosByNombre(String nombre, int page, int size);
    Page<EspacioFisico> getEspaciosFisicosByCapacidad(int capacidad, int page, int size);
}
