package com.grupo9.tpintegrador.controllers.implementations;

import com.grupo9.tpintegrador.controllers.interfaces.IReservaController;
import com.grupo9.tpintegrador.controllers.requests.reservas.CreateReservaRequest;
import com.grupo9.tpintegrador.controllers.responses.reservas.ReservaDTO;
import com.grupo9.tpintegrador.data.models.Reserva;
import com.grupo9.tpintegrador.services.interfaces.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservaControllerImpl implements IReservaController {

    @Autowired
    IReservaService reservaService;

    @Override
    public ReservaDTO createReserva(CreateReservaRequest request) {
        return reservaService.createReserva(request);
    }

    @Override
    public ReservaDTO updateReserva(CreateReservaRequest request, String id) {
        return reservaService.updateReserva(request, id);
    }

    @Override
    public Page<ReservaDTO> getReservas(String nombre, Pageable pageable) {
        return reservaService.getReservas(nombre, pageable);
    }

    @Override
    public Reserva getReservaById(String id) {
        return reservaService.getReservaById(id);
    }

    @Override
    public void deleteReserva(String id) {
        reservaService.deleteReserva(id);
    }
}
