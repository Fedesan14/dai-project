package com.grupo9.tpintegrador.controllers.interfaces;

import com.grupo9.tpintegrador.controllers.requests.reservas.CreateReservaRequest;
import com.grupo9.tpintegrador.controllers.responses.reservas.ReservaDTO;
import com.grupo9.tpintegrador.data.models.Reserva;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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
    Page<ReservaDTO> getReservas(
            @RequestParam(required = false) String cliente,
            @RequestParam(required = false) String espacio,
            @ParameterObject Pageable pageable
    );

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    Reserva getReservaById(@PathVariable String id);

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    void deleteReserva(@PathVariable String id);

}
