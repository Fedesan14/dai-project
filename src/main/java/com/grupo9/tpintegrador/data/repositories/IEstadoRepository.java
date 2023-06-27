package com.grupo9.tpintegrador.data.repositories;

import com.grupo9.tpintegrador.data.models.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IEstadoRepository extends JpaRepository<Estado, UUID> {
    boolean existsByNombre(String nombre);

    Optional<Estado> findByNombre(String nombre);
}
