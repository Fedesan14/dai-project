package com.grupo9.tpintegrador.controllers.implementations;

import com.grupo9.tpintegrador.controllers.interfaces.IEspacioFisicoController;
import com.grupo9.tpintegrador.controllers.requests.espacios.SaveEspacioFisicoRequest;
import com.grupo9.tpintegrador.data.models.EspacioFisico;
import com.grupo9.tpintegrador.services.interfaces.IEspacioFisicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class EspacioFisicoController implements IEspacioFisicoController {

    @Autowired
    IEspacioFisicoService espacioFisicoService;

    @Override
    public EspacioFisico saveEspacioFisico(SaveEspacioFisicoRequest request) {
        return espacioFisicoService.saveEspacioFisico(request);
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
