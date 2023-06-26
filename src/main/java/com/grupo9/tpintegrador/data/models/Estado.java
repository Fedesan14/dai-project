package com.grupo9.tpintegrador.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Estado {

    @Id
    private UUID id = UUID.randomUUID();
    private String nombre;
    private String descripcion;

}
