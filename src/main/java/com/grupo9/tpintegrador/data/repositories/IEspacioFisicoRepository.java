package com.grupo9.tpintegrador.data.repositories;

import com.grupo9.tpintegrador.data.models.EspacioFisico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IEspacioFisicoRepository extends PagingAndSortingRepository<EspacioFisico, UUID>, JpaRepository<EspacioFisico, UUID> {
    Page<EspacioFisico> findByNombreIgnoreCaseContainsAndCapacidad(String nombre, int capacidad, Pageable pageable);
    Page<EspacioFisico> findByNombreIgnoreCaseContains(String nombre, Pageable pageable);
    Page<EspacioFisico> findByCapacidad(int capacidad, Pageable pageable);
    Page<EspacioFisico> findAll(Pageable pageable);

    List<EspacioFisico> findByHabilitadoTrue();
}
