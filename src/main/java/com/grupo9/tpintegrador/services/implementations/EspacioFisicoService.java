package com.grupo9.tpintegrador.services.implementations;

import com.grupo9.tpintegrador.data.models.EspacioFisico;
import com.grupo9.tpintegrador.data.repositories.IEspacioFisicoRepository;
import com.grupo9.tpintegrador.services.interfaces.IEspacioFisicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class EspacioFisicoService implements IEspacioFisicoService {
    @Autowired
    IEspacioFisicoRepository espacioFisicoRepository;
    @Override
    public EspacioFisico saveEspacioFisico(EspacioFisico espacioFisico) {
        return espacioFisicoRepository.save(
                new EspacioFisico(
                    espacioFisico.getNombre(),
                    espacioFisico.getDescripcion(),
                    espacioFisico.getCapacidad(),
                    espacioFisico.isHabilitado()
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
}
