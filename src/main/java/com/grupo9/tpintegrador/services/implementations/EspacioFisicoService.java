package com.grupo9.tpintegrador.services.implementations;

import com.grupo9.tpintegrador.controllers.requests.espacios.SaveEspacioFisicoRequest;
import com.grupo9.tpintegrador.data.models.EspacioFisico;
import com.grupo9.tpintegrador.data.models.RecursoTecnologico;
import com.grupo9.tpintegrador.data.repositories.IEspacioFisicoRepository;
import com.grupo9.tpintegrador.services.interfaces.IEspacioFisicoService;
import com.grupo9.tpintegrador.services.interfaces.IRecursoTecnologicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EspacioFisicoService implements IEspacioFisicoService {
    @Autowired
    IEspacioFisicoRepository espacioFisicoRepository;
    @Autowired
    IRecursoTecnologicoService recursoTecnologicoService;


    @Override
    public EspacioFisico saveEspacioFisico(SaveEspacioFisicoRequest request) {

        List<RecursoTecnologico> recursos = request.getRecursosId().stream().map(
                recursoId -> recursoTecnologicoService.getRecursoTecnologico(recursoId)
        ).collect(Collectors.toList());

        return espacioFisicoRepository.save(
                new EspacioFisico(
                        request.getNombre(),
                        request.getDescripcion(),
                        request.getCapacidad(),
                        request.isHabilitado(),
                        recursos
                )
        );
    }

    @Override
    public List<EspacioFisico> getEspaciosFisicos() {
        return espacioFisicoRepository.findAll();
    }

    @Override
    public String deleteEspacioFisico(String id) {
        EspacioFisico espacioFisico = getEspacioFisico(id);
        espacioFisicoRepository.delete(espacioFisico);
        return id;
    }

    @Override
    public EspacioFisico updateEspacioFisico(EspacioFisico espacioFisico, String id) {
        EspacioFisico foundEspacioFisico = getEspacioFisico(id);

        foundEspacioFisico.setNombre(espacioFisico.getNombre());
        foundEspacioFisico.setCapacidad(espacioFisico.getCapacidad());
        foundEspacioFisico.setDescripcion(espacioFisico.getDescripcion());
        foundEspacioFisico.setHabilitado(espacioFisico.isHabilitado());
        return espacioFisicoRepository.save(foundEspacioFisico);
    }

    @Override
    public EspacioFisico getEspacioFisico(String id) {
        return espacioFisicoRepository.findById(UUID.fromString(id)).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"El espacio físico con el id: "+id+" no fue encontrado.")
        );
    }

    @Override
    public void addRecurso(String espacioId, String recursoId) {
        RecursoTecnologico recursoTecnologico = recursoTecnologicoService.getRecursoTecnologico(recursoId);
        EspacioFisico espacioFisico = getEspacioFisico(espacioId);

        espacioFisico.getRecursos().add(recursoTecnologico);
        espacioFisicoRepository.save(espacioFisico);
    }

    @Override
    public void removeRecurso(String espacioId, String recursoId) {
        RecursoTecnologico recursoTecnologico = recursoTecnologicoService.getRecursoTecnologico(recursoId);
        EspacioFisico espacioFisico = getEspacioFisico(espacioId);

        espacioFisico.getRecursos().remove(recursoTecnologico);
        espacioFisicoRepository.save(espacioFisico);
    }

    @Override
    public Page<EspacioFisico> getEspaciosFisicosByNombreAndCapacidad(String nombre, int capacidad, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return espacioFisicoRepository.findByNombreIgnoreCaseContainsAndCapacidad(nombre, capacidad, pageable);
    }

    @Override
    public Page<EspacioFisico> getEspaciosFisicosByNombre(String nombre, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return espacioFisicoRepository.findByNombreIgnoreCaseContains(nombre, pageable);
    }

    @Override
    public Page<EspacioFisico> getEspaciosFisicosByCapacidad(int capacidad, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return espacioFisicoRepository.findByCapacidad(capacidad, pageable);
    }
}
