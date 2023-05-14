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
public class RecursoTecnologico {
    @Id
    private UUID id = UUID.randomUUID();
    private String nombre;
    private String descripcion;
}
