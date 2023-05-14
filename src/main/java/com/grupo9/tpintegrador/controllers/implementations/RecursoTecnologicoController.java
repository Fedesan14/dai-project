package com.grupo9.tpintegrador.controllers.implementations;

import com.grupo9.tpintegrador.controllers.interfaces.IRecursoTecnologicoController;
import com.grupo9.tpintegrador.services.interfaces.IRecursoTecnologicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecursoTecnologicoController implements IRecursoTecnologicoController {

    @Autowired
    IRecursoTecnologicoService recursoTecnologicoService;

}
