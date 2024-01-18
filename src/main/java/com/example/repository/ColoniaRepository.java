package com.example.repository;

import com.example.entity.CP;
import com.example.entity.Colonia;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

@Repository
public interface ColoniaRepository extends JpaRepository<Colonia, String> {
    @Query("SELECT m FROM Colonia m JOIN FETCH m.cp WHERE m.cp.cp = :Icodigo")
    Set<Colonia> showColCp(Integer Icodigo);

    @Query("SELECT m FROM Colonia m JOIN FETCH m.cp WHERE m.cp.municipio.estado.id_estado= :id AND m.cp.municipio.id_municipios =:id2")
    List<Colonia> showColEdoMu(Integer id,Integer id2);
}
