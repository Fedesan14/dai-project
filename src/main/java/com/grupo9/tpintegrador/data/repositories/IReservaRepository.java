package com.grupo9.tpintegrador.data.repositories;

import com.grupo9.tpintegrador.data.models.EspacioFisico;
import com.grupo9.tpintegrador.data.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IReservaRepository extends JpaRepository<Reserva, UUID> {
    Optional<Reserva> findByFechaHoraDesdeReserva(LocalDateTime fechaHoraDesdeReserva);

    List<Reserva> findAllByEspacioFisico(EspacioFisico espacioFisico);
}
