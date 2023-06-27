package com.grupo9.tpintegrador.controllers.requests.reservas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CreateReservaRequest {

    private LocalDate fechaReserva;
    private LocalDate fechaCreacion;
    private String motivoRechazo;
    private String motivoReserva;
    private String espacioFisicoId;
    private String clienteId;

}
