package com.grupo9.tpintegrador.data.repositories;

import com.grupo9.tpintegrador.data.models.Estado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IEstadoRepository extends JpaRepository<Estado, UUID> {
    boolean existsByNombre(String nombre);

    Optional<Estado> findByNombre(String nombre);

    @Query("SELECT e FROM Estado e WHERE (:nombre is null OR e.nombre LIKE CONCAT('%', :nombre, '%'))")
    Page<Estado> findAllByNombre(@Param("nombre") String nombre, Pageable pageable);
}
