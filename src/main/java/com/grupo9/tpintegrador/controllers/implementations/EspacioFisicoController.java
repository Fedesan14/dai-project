package com.grupo9.tpintegrador.controllers.implementations;

import com.grupo9.tpintegrador.controllers.interfaces.IEspacioFisicoController;
import com.grupo9.tpintegrador.services.interfaces.IEspacioFisicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EspacioFisicoController implements IEspacioFisicoController {

    @Autowired
    IEspacioFisicoService espacioFisicoService;

}
