package com.grupo9.tpintegrador.data.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Cliente {

    @Id
    private UUID id = UUID.randomUUID();
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @Column(nullable = false)
    private String dni;
    @Column(nullable = false)
    private String email;
    private String nroTelefono;
    @OneToMany
    private List<Reserva> reservas = new ArrayList<>();

}
