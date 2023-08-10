package com.grupo9.tpintegrador.controllers.interfaces;

import com.grupo9.tpintegrador.controllers.requests.reservas.CreateReservaRequest;
import com.grupo9.tpintegrador.controllers.responses.reservas.ReservaDTO;
import com.grupo9.tpintegrador.data.models.Reserva;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/reservas")
@CrossOrigin
public interface IReservaController {

    @PostMapping
    @ResponseStatus(CREATED)
    ReservaDTO createReserva(@RequestBody CreateReservaRequest request);

    @GetMapping
    @ResponseStatus(OK)
    List<Reserva> getReservas();

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    Reserva getReservaById(@PathVariable String id);

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    void deleteReserva(@PathVariable String id);

}
