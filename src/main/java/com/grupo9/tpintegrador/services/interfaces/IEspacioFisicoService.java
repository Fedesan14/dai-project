package com.grupo9.tpintegrador.services.interfaces;

import com.grupo9.tpintegrador.controllers.requests.espacios.SaveEspacioFisicoRequest;
import com.grupo9.tpintegrador.data.models.EspacioFisico;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IEspacioFisicoService {
    EspacioFisico saveEspacioFisico(SaveEspacioFisicoRequest request);

    List<EspacioFisico> getEspaciosFisicos();

    String deleteEspacioFisico(String id);

    EspacioFisico updateEspacioFisico(EspacioFisico espacioFisico, String id);

    EspacioFisico getEspacioFisico(String id);

    void addRecurso(String espacioId, String recursoId);
    void removeRecurso(String espacioId, String recursoId);

    Page<EspacioFisico> getEspaciosFisicosByNombreAndCapacidad(String nombre, int capacidad, int page, int size);
    Page<EspacioFisico> getEspaciosFisicosByNombre(String nombre, int page, int size);
    Page<EspacioFisico> getEspaciosFisicosByCapacidad(int capacidad, int page, int size);
}
