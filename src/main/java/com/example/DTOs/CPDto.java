package com.example.DTOs;

import com.example.entity.Colonia;
import com.example.entity.Estado;
import com.example.entity.Municipio;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Serdeable.Serializable
public class CPDto {
    private Integer estado_id;
    private Integer municipio_id;
    private String estado;
    private String municipio;
    private Integer codigo_postal;



}
