package com.example.repository;

import com.example.entity.Estado;
import com.example.entity.Municipio;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Set;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Integer> {

   @Query("SELECT m FROM Municipio m JOIN FETCH m.estado WHERE m.estado.id_estado = :IdEstado")
   Set<Municipio> showMunPorEdo(Integer IdEstado);




}
