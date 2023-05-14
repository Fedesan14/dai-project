package com.grupo9.tpintegrador.services.implementations;

import com.grupo9.tpintegrador.data.repositories.IRecursoTecnologicoRepository;
import com.grupo9.tpintegrador.services.interfaces.IRecursoTecnologicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecursoTecnologicoService implements IRecursoTecnologicoService {

    @Autowired
    IRecursoTecnologicoRepository recursoTecnologicoRepository;


}
