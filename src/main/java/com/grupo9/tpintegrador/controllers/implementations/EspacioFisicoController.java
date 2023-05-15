package com.grupo9.tpintegrador.controllers.implementations;

import com.grupo9.tpintegrador.controllers.interfaces.IEspacioFisicoController;
import com.grupo9.tpintegrador.data.models.EspacioFisico;
import com.grupo9.tpintegrador.services.interfaces.IEspacioFisicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController()
public class EspacioFisicoController implements IEspacioFisicoController {

    @Autowired
    IEspacioFisicoService espacioFisicoService;

    @Override
    public EspacioFisico saveEspacioFisico(EspacioFisico espacioFisico) {
        return espacioFisicoService.saveEspacioFisico(espacioFisico);
    }

    @Override
    public List<EspacioFisico> getEspaciosFisicos() {
        return espacioFisicoService.getEspaciosFisicos();
    }

    @Override
    public EspacioFisico getEspacioFisico(String id) {
        return espacioFisicoService.getEspacioFisico(id);
    }

    @Override
    public String deleteEspacioFisico(String id) {
        return espacioFisicoService.deleteEspacioFisico(id);
    }

    @Override
    public EspacioFisico updateEspacioFisico(EspacioFisico espacioFisico, String id) {
        return espacioFisicoService.updateEspacioFisico(espacioFisico, id);
    }
}
