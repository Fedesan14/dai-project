package com.grupo9.tpintegrador.data.repositories;

import com.grupo9.tpintegrador.data.models.EspacioFisico;
import com.grupo9.tpintegrador.data.models.RecursoTecnologico;
import com.grupo9.tpintegrador.data.models.Reserva;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IReservaRepository extends JpaRepository<Reserva, UUID> {
    Optional<Reserva> findByFechaHoraDesdeReserva(LocalDateTime fechaHoraDesdeReserva);

    @Query("SELECT r FROM Reserva r WHERE (:nombre is null OR r.cliente.nombre LIKE CONCAT('%', :nombre, '%'))")
    Page<Reserva> findAllByNombreCliente(@Param("nombre") String nombre, Pageable pageable);

    List<Reserva> findAllByEspacioFisico(EspacioFisico espacioFisico);
}
