package com.grupo9.tpintegrador.controllers.responses.clientes;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    private String id;
    private String nombre;
    private String apellido;
}
