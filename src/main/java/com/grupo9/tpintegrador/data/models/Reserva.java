package com.grupo9.tpintegrador.data.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Reserva {

    @Id
    private UUID id = UUID.randomUUID();
    @Column(nullable = false)
    private LocalDate fechaReserva;
    @Column(nullable = false)
    private LocalDate fechaCreacion;
    private String motivoRechazo;
    private String motivoReserva;
    @ManyToOne
    private Estado estado;
    @ManyToOne
    private EspacioFisico espacioFisico;

}
