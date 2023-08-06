package com.grupo9.tpintegrador.services.implementations;

import com.grupo9.tpintegrador.controllers.requests.reservas.CreateReservaRequest;
import com.grupo9.tpintegrador.controllers.responses.clientes.ClienteDTO;
import com.grupo9.tpintegrador.controllers.responses.reservas.ReservaDTO;
import com.grupo9.tpintegrador.data.models.Reserva;
import com.grupo9.tpintegrador.data.repositories.IReservaRepository;
import com.grupo9.tpintegrador.services.interfaces.IClientService;
import com.grupo9.tpintegrador.services.interfaces.IEspacioFisicoService;
import com.grupo9.tpintegrador.services.interfaces.IEstadoService;
import com.grupo9.tpintegrador.services.interfaces.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ReservaServiceImpl implements IReservaService {

    @Autowired
    IReservaRepository reservaRepository;
    @Autowired
    IEstadoService estadoService;
    @Autowired
    IEspacioFisicoService espacioFisicoService;
    @Autowired
    IClientService clientService;


    @Override
    public ReservaDTO createReserva(CreateReservaRequest request) {

        List<Reserva> reservas = reservaRepository.findAll();

        reservas.forEach(reserva -> {
            if (coincideConOtraReserva(request, reserva)) {
                throw new ResponseStatusException(BAD_REQUEST, "Ya existe una reserva para la fecha y horas ingresadas.");
            }
        });

        return buildReservaDTO(
                reservaRepository.save(new Reserva(
                                request.getFechaHoraDesdeReserva(),
                                request.getFechaHoraHastaReserva(),
                                LocalDate.now(),
                                request.getMotivoReserva(),
                                estadoService.getCreatedState(),
                                espacioFisicoService.getEspacioFisico(request.getEspacioFisicoId()),
                                clientService.getClientById(request.getClienteId())

                        )

        ));
    }

    @Override
    public List<Reserva> getReservas() {
        return reservaRepository.findAll();
    }

    @Override
    public Reserva getReservaById(String id) {
        return reservaRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "No se encontró la reserva con el id " + id));
    }

    @Override
    public void deleteReserva(String id) {
        Reserva reservaToDelete = reservaRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "No se encontró la reserva con el id " + id));

        reservaRepository.delete(reservaToDelete);
    }

    private static boolean coincideConOtraReserva(CreateReservaRequest request, Reserva reserva) {
        return (request.getFechaHoraHastaReserva().isAfter(reserva.getFechaHoraDesdeReserva()) && request.getFechaHoraHastaReserva().isBefore(reserva.getFechaHoraHastaReserva())) ||
                (request.getFechaHoraDesdeReserva().isAfter(reserva.getFechaHoraDesdeReserva()) && request.getFechaHoraDesdeReserva().isBefore(reserva.getFechaHoraHastaReserva())) ||
                (request.getFechaHoraDesdeReserva().isBefore(reserva.getFechaHoraDesdeReserva()) && request.getFechaHoraHastaReserva().isAfter(reserva.getFechaHoraHastaReserva())) ||
                (request.getFechaHoraDesdeReserva().isEqual(reserva.getFechaHoraDesdeReserva()) && request.getFechaHoraHastaReserva().isEqual(reserva.getFechaHoraHastaReserva()));
    }

    private ReservaDTO buildReservaDTO(Reserva reserva) {
        return new ReservaDTO(
                reserva.getId(),
                reserva.getFechaHoraDesdeReserva(),
                reserva.getFechaHoraHastaReserva(),
                reserva.getFechaCreacion(),
                reserva.getMotivoRechazo(),
                reserva.getMotivoReserva(),
                reserva.getEstado(),
                reserva.getEspacioFisico(),
                new ClienteDTO(
                        reserva.getCliente().getNombre(),
                        reserva.getCliente().getApellido()
                )
        );
    }
}
