package com.prueba.restfull.model;

import com.prueba.restfull.entity.TipoDocumento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientModel {

    private Long documento;
    private String tipoDocumneto;
    private String nombreCompleto;
    private String fechaNacimiento;
}
