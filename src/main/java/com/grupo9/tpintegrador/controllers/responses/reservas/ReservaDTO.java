package com.grupo9.tpintegrador.controllers.responses.reservas;

import com.grupo9.tpintegrador.controllers.responses.clientes.ClienteDTO;
import com.grupo9.tpintegrador.data.models.EspacioFisico;
import com.grupo9.tpintegrador.data.models.Estado;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReservaDTO {
    private UUID id;
    private LocalDateTime fechaHoraDesdeReserva;
    private LocalDateTime fechaHoraHastaReserva;
    private LocalDate fechaCreacion;
    private String motivoRechazo;
    private String motivoReserva;
    private Estado estado;
    private EspacioFisico espacioFisico;
    private ClienteDTO cliente;
}
