package com.grupo9.tpintegrador.controllers.responses.reservas;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grupo9.tpintegrador.controllers.responses.clientes.ClienteDTO;
import com.grupo9.tpintegrador.data.models.EspacioFisico;
import com.grupo9.tpintegrador.data.models.Estado;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReservaDTO {
    private UUID id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private Date fechaHoraDesdeReserva;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private Date fechaHoraHastaReserva;
    private LocalDate fechaCreacion;
    private String motivoRechazo;
    private String motivoReserva;
    private Estado estado;
    private EspacioFisico espacioFisico;
    private ClienteDTO cliente;
}
