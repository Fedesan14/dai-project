package com.grupo9.tpintegrador.services.interfaces;

import com.grupo9.tpintegrador.controllers.requests.reservas.CreateReservaRequest;
import com.grupo9.tpintegrador.data.models.Reserva;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

public interface IReservaService {

    Reserva createReserva(@RequestBody CreateReservaRequest request);
    List<Reserva> getReservas();
    Reserva getReservaById(@PathVariable String id);
    void deleteReserva(@PathVariable String id);

}
