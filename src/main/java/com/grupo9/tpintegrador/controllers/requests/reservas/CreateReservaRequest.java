package com.grupo9.tpintegrador.controllers.requests.reservas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CreateReservaRequest {

    private LocalDateTime fechaHoraDesdeReserva;
    private LocalDateTime fechaHoraHastaReserva;
    private LocalDate fechaCreacion;
    private String motivoRechazo;
    private String motivoReserva;
    private String espacioFisicoId;
    private String clienteId;

    @Override
    public String toString() {
        return "CreateReservaRequest{" +
                "fechaHoraDesdeReserva=" + fechaHoraDesdeReserva +
                ", fechaHoraHastaReserva=" + fechaHoraHastaReserva +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }

}
