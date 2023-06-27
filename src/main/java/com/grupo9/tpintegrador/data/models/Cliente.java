package com.grupo9.tpintegrador.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    public Cliente(String nombre, String apellido, String dni, String email, String nroTelefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.nroTelefono = nroTelefono;
    }
}
