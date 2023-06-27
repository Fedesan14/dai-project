package com.grupo9.tpintegrador.controllers.requests.clients;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SaveClientRequest {

    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String nroTelefono;

}
