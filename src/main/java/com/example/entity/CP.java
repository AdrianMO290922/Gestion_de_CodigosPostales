package com.example.entity;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CP")
@Serdeable.Serializable
public class CP {

    @Id
    @ManyToOne
    @JoinColumn(name = "Id_Municipios")
    private Municipio id_municipio;

    @Column(name = "CP")
    private Integer cp;

}
