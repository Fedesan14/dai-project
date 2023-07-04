package com.grupo9.tpintegrador.services.implementations;

import com.grupo9.tpintegrador.data.models.RecursoTecnologico;
import com.grupo9.tpintegrador.data.repositories.IRecursoTecnologicoRepository;
import com.grupo9.tpintegrador.services.interfaces.IRecursoTecnologicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class RecursoTecnologicoService implements IRecursoTecnologicoService {

    @Autowired
    IRecursoTecnologicoRepository recursoTecnologicoRepository;

    @Override
    public RecursoTecnologico saveRecursoTecnologico(RecursoTecnologico recursoTecnologico) {
        return recursoTecnologicoRepository.save(
                new RecursoTecnologico(
                        recursoTecnologico.getNombre(),
                        recursoTecnologico.getDescripcion()
                )
        );
    }

    @Override
    public Page<RecursoTecnologico> getRecursosTecnologicos(String nombre, Pageable pageable) {
        return recursoTecnologicoRepository.findAllByNombre(nombre, pageable);
    }

    @Override
    public String deleteRecursoTecnologico(String id) {
        RecursoTecnologico recursoTecnologico = getRecursoTecnologico(id);
        recursoTecnologicoRepository.delete(recursoTecnologico);
        return id;
    }

    @Override
    public RecursoTecnologico updateRecursoTecnologico(RecursoTecnologico recursoTecnologico, String id) {
        RecursoTecnologico foundRecursoTecnologico = getRecursoTecnologico(id);

        foundRecursoTecnologico.setNombre(recursoTecnologico.getNombre());
        foundRecursoTecnologico.setDescripcion(recursoTecnologico.getDescripcion());
        return recursoTecnologicoRepository.save(foundRecursoTecnologico);
    }

    @Override
    public RecursoTecnologico getRecursoTecnologico(String id) {
        return recursoTecnologicoRepository.findById(UUID.fromString(id)).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"El recurso tecnologico con el id: "+id+" no fue encontrado.")
        );
    }

    @Override
    public Iterable<RecursoTecnologico> getFiltroNombre(String nombre) {
        return recursoTecnologicoRepository.findByNombreIgnoreCaseContains(nombre);
    }
}
