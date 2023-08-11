package com.grupo9.tpintegrador.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reserva {

    @Id
    private UUID id = UUID.randomUUID();
    @Column(nullable = false)
    private Date fechaHoraDesdeReserva;
    @Column(nullable = false)
    private Date fechaHoraHastaReserva;
    @Column(nullable = false)
    private LocalDate fechaCreacion;
    private String motivoRechazo;
    private String motivoReserva;
    @ManyToOne
    private Estado estado;
    @ManyToOne
    private EspacioFisico espacioFisico;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Reserva(Date fechaHoraDesdeReserva, Date fechaHoraHastaReserva, LocalDate fechaCreacion, String motivoReserva, Estado estado, EspacioFisico espacioFisico, Cliente cliente) {
        this.fechaHoraDesdeReserva = fechaHoraDesdeReserva;
        this.fechaHoraHastaReserva = fechaHoraHastaReserva;
        this.fechaCreacion = fechaCreacion;
        this.motivoReserva = motivoReserva;
        this.estado = estado;
        this.espacioFisico = espacioFisico;
        this.cliente = cliente;
    }
}
