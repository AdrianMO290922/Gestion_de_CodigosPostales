package com.example.payload;

import com.example.entity.Estado;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
@Builder
@Serdeable.Serializable
public class MensajeResponse implements Serializable {
    private Boolean error;
    private String mensaje;
    private Object estado;
    private List<Estado> estados;
    private Object municipios;
    private Object colonias;
    private Object codigo_postal;
}

