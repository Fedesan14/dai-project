package com.grupo9.tpintegrador.controllers.requests.reservas;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CreateReservaRequest {

    private Date fechaHoraDesdeReserva;
    private Date fechaHoraHastaReserva;
    private String motivoRechazo;
    private String motivoReserva;
    private String espacioFisicoId;
    private String clienteId;

    @Override
    public String toString() {
        return "CreateReservaRequest{" +
                "fechaHoraDesdeReserva=" + fechaHoraDesdeReserva +
                ", fechaHoraHastaReserva=" + fechaHoraHastaReserva +
                '}';
    }

}
