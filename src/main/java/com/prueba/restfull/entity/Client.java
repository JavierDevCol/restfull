package com.prueba.restfull.entity;

import com.prueba.restfull.errorDriver.personalizeException.*;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

@Table("Cliente")
@Getter
public class Client {

    private final static String DOCUMENTO_NO_NULL = "El documento no puede ir vacio";
    private final static String TIPO_DOCUMENTO_NO_NULL = "El Tipo de documento no puede ir vacio";
    private final static String NOMBRE_NO_NULL = "El Nombre no puede ir vacio";
    private final static String FECHA_NO_NULL_OR_EMPTY = "La fecha no debe estar vacio";
    private final static String FECHA_NO_FORMAT_ISO_8601 = "La fecha no cumple el formato ISO 8601";
    private final static String FECHA_MENOR_1_Enero_1900 = "La fecha es menor que 01 de enero de 1900";
    private final static String FECHA_MAYOR_ACTUAL = "La fecha de nacimiento no puede ser mayor a la fecha actual.";
    private final static String NOMBRE_INVALIDO = "Son permitidos caracteres alfabeticos y espacios";
    private final static LocalDate FECHA_MININA_VALIDA = LocalDate.of(1900, 1, 1);
    private static final String VALID_CHARS_REGEX = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]+$";

    @Id
    private Long documento;

    private String tipoDocumento;

    private String nombreCompleto;

    private LocalDate fechaNacimiento;

    public Client(Long documento, String tipoDocumento, String nombreCompleto, LocalDate fechaNacimiento) {
        this.validarNoNull(documento,tipoDocumento,nombreCompleto);
        this.validarFechaNacimiento(fechaNacimiento);
        this.validarNombreCompleto(nombreCompleto);

        this.tipoDocumento = TipoDocumento.getTipo(tipoDocumento);
        this.documento = documento;
        this.nombreCompleto = nombreCompleto;
    }

    private void validarFechaNacimiento(LocalDate fechaIso) {
        if (Objects.nonNull(fechaIso)) {
            if (fechaIso.isBefore(FECHA_MININA_VALIDA)) {
                this.fechaNacimiento = null;
                throw new ExceptionFechaMinima(FECHA_MENOR_1_Enero_1900);
            }

            LocalDate fechaActual = LocalDate.now();
            if (fechaIso.isAfter(fechaActual)) {
                this.fechaNacimiento = null;
                throw new ExceptionFechaMaxima(FECHA_MAYOR_ACTUAL);
            }
        }
    }

    private void validarNoNull(Long documento, String tipoDocumneto, String nombreCompleto) {
        if (Objects.isNull(documento)) {
            throw new ExceptionDocumentoNotNull(DOCUMENTO_NO_NULL);
        }
        if (Objects.isNull(tipoDocumneto)) {
            throw new ExceptionDocumentoNotNull(TIPO_DOCUMENTO_NO_NULL);
        }
        if (Objects.isNull(nombreCompleto)) {
            throw new ExceptionDocumentoNotNull(NOMBRE_NO_NULL);
        }
    }

    private void validarNombreCompleto(String nombreCompleto) {
        if (!nombreCompleto.matches(VALID_CHARS_REGEX)) {
            throw new ExceptionNombreInvalido(NOMBRE_INVALIDO);
        }
    }

}