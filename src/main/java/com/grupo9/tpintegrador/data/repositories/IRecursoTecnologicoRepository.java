package com.grupo9.tpintegrador.data.repositories;

import com.grupo9.tpintegrador.data.models.EspacioFisico;
import com.grupo9.tpintegrador.data.models.RecursoTecnologico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IRecursoTecnologicoRepository extends JpaRepository<RecursoTecnologico, UUID> {
    Optional<RecursoTecnologico> findById(String id);
}
