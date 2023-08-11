package com.grupo9.tpintegrador.services.interfaces;

import com.grupo9.tpintegrador.controllers.requests.reservas.CreateReservaRequest;
import com.grupo9.tpintegrador.controllers.responses.reservas.ReservaDTO;
import com.grupo9.tpintegrador.data.models.Reserva;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface IReservaService {

    ReservaDTO createReserva(@RequestBody CreateReservaRequest request);
    Page<ReservaDTO> getReservas(String nombre, String espacio, Pageable pageable);
    ReservaDTO updateReserva(@RequestBody CreateReservaRequest request, String id);
    ReservaDTO getReservaDTOById(@PathVariable String id);
    Reserva getReservaById(@PathVariable String id);
    void deleteReserva(@PathVariable String id);

}
