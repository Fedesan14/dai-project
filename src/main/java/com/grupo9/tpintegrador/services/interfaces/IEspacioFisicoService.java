package com.grupo9.tpintegrador.services.interfaces;

import com.grupo9.tpintegrador.controllers.requests.espacios.EspacioFisicoRequest;
import com.grupo9.tpintegrador.data.models.EspacioFisico;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IEspacioFisicoService {
    EspacioFisico saveEspacioFisico(EspacioFisicoRequest request);

    Page<EspacioFisico> getEspaciosFisicos(int page, int size, String sort, String order);
    List<EspacioFisico> getEspaciosFisicosHabilitados();

    void deleteEspacioFisico(String id);

    EspacioFisico updateEspacioFisico(EspacioFisicoRequest request, String id);

    EspacioFisico getEspacioFisico(String id);

    void addRecurso(String espacioId, String recursoId);
    void removeRecurso(String espacioId, String recursoId);

    Page<EspacioFisico> getEspaciosFisicosByNombreAndCapacidad(String nombre, int capacidad, int page, int size, String sort, String order);
    Page<EspacioFisico> getEspaciosFisicosByNombre(String nombre, int page, int size, String sort, String order);
    Page<EspacioFisico> getEspaciosFisicosByCapacidad(int capacidad, int page, int size, String sort, String order);
}
