package com.grupo9.tpintegrador.data.repositories;

import com.grupo9.tpintegrador.data.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public interface IReservaRepository extends JpaRepository<Reserva, UUID> {
    Optional<Reserva> findByFechaReserva(LocalDate fechaReserva);
}
