package com.grupo9.tpintegrador.services.implementations;

import com.grupo9.tpintegrador.controllers.requests.espacios.EspacioFisicoRequest;
import com.grupo9.tpintegrador.data.models.EspacioFisico;
import com.grupo9.tpintegrador.data.models.RecursoTecnologico;
import com.grupo9.tpintegrador.data.repositories.IEspacioFisicoRepository;
import com.grupo9.tpintegrador.data.repositories.IRecursoTecnologicoRepository;
import com.grupo9.tpintegrador.services.interfaces.IEspacioFisicoService;
import com.grupo9.tpintegrador.services.interfaces.IRecursoTecnologicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EspacioFisicoService implements IEspacioFisicoService {
    @Autowired
    IEspacioFisicoRepository espacioFisicoRepository;
    @Autowired
    IRecursoTecnologicoService recursoTecnologicoService;
    @Autowired
    private IRecursoTecnologicoRepository iRecursoTecnologicoRepository;


    @Override
    public EspacioFisico saveEspacioFisico(EspacioFisicoRequest request) {

        List<RecursoTecnologico> recursos = new ArrayList<>();

        if(!request.getRecursosId().isEmpty()){
            recursos = request.getRecursosId().stream().map(
                    recursoId -> recursoTecnologicoService.getRecursoTecnologico(recursoId)
            ).collect(Collectors.toList());
        }

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
    public Page<EspacioFisico> getEspaciosFisicos(int page, int size,String sort, String order) {
        Sort sortObj = Sort.by(order.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sort);
        Pageable pageable = PageRequest.of(page, size, sortObj);
        return espacioFisicoRepository.findAll(pageable);
    }

    @Override
    public void deleteEspacioFisico(String id) {
        EspacioFisico espacioFisico = getEspacioFisico(id);
        espacioFisicoRepository.delete(espacioFisico);
    }

    @Override
    public EspacioFisico updateEspacioFisico(EspacioFisicoRequest request, String id) {
        EspacioFisico foundEspacioFisico = getEspacioFisico(id);
        List<RecursoTecnologico> recursos = new ArrayList<>();

        if(!request.getRecursosId().isEmpty()){
            recursos = request.getRecursosId().stream().map(
                    recursoId -> recursoTecnologicoService.getRecursoTecnologico(recursoId)
            ).collect(Collectors.toList());
        }
        foundEspacioFisico.setNombre(request.getNombre());
        foundEspacioFisico.setCapacidad(request.getCapacidad());
        foundEspacioFisico.setDescripcion(request.getDescripcion());
        foundEspacioFisico.setHabilitado(request.isHabilitado());
        foundEspacioFisico.setRecursos(new ArrayList<>());
        foundEspacioFisico.setRecursos(recursos);
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
    public Page<EspacioFisico> getEspaciosFisicosByNombreAndCapacidad(String nombre, int capacidad, int page, int size,
                                                                      String sort, String order) {

        Sort sortObj = Sort.by(order.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sort);
        Pageable pageable = PageRequest.of(page, size, sortObj);
        return espacioFisicoRepository.findByNombreIgnoreCaseContainsAndCapacidad(nombre, capacidad, pageable);
    }

    @Override
    public Page<EspacioFisico> getEspaciosFisicosByNombre(String nombre, int page, int size, String sort, String order) {
        Sort sortObj = Sort.by(order.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sort);
        Pageable pageable = PageRequest.of(page, size, sortObj);
        return espacioFisicoRepository.findByNombreIgnoreCaseContains(nombre, pageable);
    }

    @Override
    public Page<EspacioFisico> getEspaciosFisicosByCapacidad(int capacidad, int page, int size, String sort, String order) {
        Sort sortObj = Sort.by(order.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sort);
        Pageable pageable = PageRequest.of(page, size, sortObj);
        return espacioFisicoRepository.findByCapacidad(capacidad, pageable);
    }
}
