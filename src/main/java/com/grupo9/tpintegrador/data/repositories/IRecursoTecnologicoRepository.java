package com.grupo9.tpintegrador.data.repositories;

import com.grupo9.tpintegrador.data.models.EspacioFisico;
import com.grupo9.tpintegrador.data.models.RecursoTecnologico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IRecursoTecnologicoRepository extends JpaRepository<RecursoTecnologico, UUID> {
    Iterable<RecursoTecnologico> findByNombreIgnoreCaseContains(String nombre);

    @Query("SELECT rt FROM RecursoTecnologico rt WHERE (:nombre is null OR rt.nombre LIKE CONCAT('%', :nombre, '%'))")
    Page<RecursoTecnologico> findAllByNombre(@Param("nombre") String nombre, Pageable pageable);
}
