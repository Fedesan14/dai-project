package com.grupo9.tpintegrador.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;
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

    @ColumnDefault(value= "1")
    private boolean habilitado;
    @ManyToMany
    private List<RecursoTecnologico> recursos;

    public EspacioFisico(String nombre, String descripcion, int capacidad, boolean habilitado, List<RecursoTecnologico> recursos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.habilitado = habilitado;
        this.recursos = recursos;
    }
}
