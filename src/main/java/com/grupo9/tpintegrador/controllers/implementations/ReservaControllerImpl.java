package com.grupo9.tpintegrador.controllers.implementations;

import com.grupo9.tpintegrador.controllers.interfaces.IReservaController;
import com.grupo9.tpintegrador.controllers.requests.reservas.CreateReservaRequest;
import com.grupo9.tpintegrador.controllers.responses.reservas.ReservaDTO;
import com.grupo9.tpintegrador.data.models.Reserva;
import com.grupo9.tpintegrador.services.interfaces.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservaControllerImpl implements IReservaController {

    @Autowired
    IReservaService reservaService;

    @Override
    public ReservaDTO createReserva(CreateReservaRequest request) {
        return reservaService.createReserva(request);
    }

    @Override
    public List<Reserva> getReservas() {
        return reservaService.getReservas();
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
