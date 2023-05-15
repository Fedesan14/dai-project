package com.grupo9.tpintegrador.controllers.requests.espacios;

import com.grupo9.tpintegrador.data.models.RecursoTecnologico;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SaveEspacioFisicoRequest {
    private String nombre;
    private String descripcion;
    private int capacidad;
    private boolean habilitado;
    private List<String> recursosId;
}
