package com.cpostalesApi.entity;


import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estados")
@Serdeable.Serializable
public class Estado {


    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estados")
    private int id_estado;

    @Column(name = "estados")
    private String estado;
}
