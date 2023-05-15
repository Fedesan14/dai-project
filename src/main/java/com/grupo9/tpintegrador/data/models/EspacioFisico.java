package com.grupo9.tpintegrador.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EspacioFisico {
    @Id
    private UUID id = UUID.randomUUID();
    private String nombre;
    private String descripcion;
    private int capacidad;
    private boolean habilitado;

    public EspacioFisico(String nombre, String descripcion, int capacidad, boolean habilitado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.habilitado = habilitado;
    }
}
