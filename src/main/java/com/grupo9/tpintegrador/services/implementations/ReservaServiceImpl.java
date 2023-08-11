package com.grupo9.tpintegrador.services.implementations;

import com.grupo9.tpintegrador.controllers.requests.reservas.CreateReservaRequest;
import com.grupo9.tpintegrador.controllers.responses.clientes.ClienteDTO;
import com.grupo9.tpintegrador.controllers.responses.reservas.ReservaDTO;
import com.grupo9.tpintegrador.data.models.EspacioFisico;
import com.grupo9.tpintegrador.data.models.Reserva;
import com.grupo9.tpintegrador.data.repositories.IReservaRepository;
import com.grupo9.tpintegrador.services.interfaces.IClientService;
import com.grupo9.tpintegrador.services.interfaces.IEspacioFisicoService;
import com.grupo9.tpintegrador.services.interfaces.IEstadoService;
import com.grupo9.tpintegrador.services.interfaces.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

        if(request.getFechaHoraDesdeReserva().after(request.getFechaHoraHastaReserva())){
            throw new ResponseStatusException(BAD_REQUEST, "La fecha desde debe ser menor a la fecha hasta");
        }

        EspacioFisico espacioFisico = espacioFisicoService.getEspacioFisico(request.getEspacioFisicoId());
        List<Reserva> reservas = reservaRepository.findAllByEspacioFisico(espacioFisico);

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
                                espacioFisico,
                                clientService.getClientById(request.getClienteId())

                        )

        ));
    }

    @Override
    public Page<ReservaDTO> getReservas(String nombre, String espacio, Pageable pageable) {
        Page<Reserva> page = reservaRepository.findAllByNombreClienteAndEspacio(nombre, espacio, pageable);
        List<ReservaDTO> reservas = page.stream().map(
                reserva -> buildReservaDTO(reserva)
        ).collect(Collectors.toList());

        return new PageImpl<>(reservas, page.getPageable(), page.getTotalElements());
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
        return (request.getFechaHoraHastaReserva().after(reserva.getFechaHoraDesdeReserva()) && request.getFechaHoraHastaReserva().before(reserva.getFechaHoraHastaReserva())) ||
                (request.getFechaHoraDesdeReserva().after(reserva.getFechaHoraDesdeReserva()) && request.getFechaHoraDesdeReserva().before(reserva.getFechaHoraHastaReserva())) ||
                (request.getFechaHoraDesdeReserva().before(reserva.getFechaHoraDesdeReserva()) && request.getFechaHoraHastaReserva().after(reserva.getFechaHoraHastaReserva())) ||
                (request.getFechaHoraDesdeReserva().equals(reserva.getFechaHoraDesdeReserva()) && request.getFechaHoraHastaReserva().equals(reserva.getFechaHoraHastaReserva()));
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
                        reserva.getCliente().getId().toString(),
                        reserva.getCliente().getNombre(),
                        reserva.getCliente().getApellido()
                )
        );
    }
}
