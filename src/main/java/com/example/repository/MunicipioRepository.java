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

   // @Query(SELECT m FROM Municipio m WHERE m.estado.id_estado = :IdEstado)
  // @Query("SELECT m FROM Municipio m JOIN FETCH m.estado WHERE m.estado.id_estado = :IdEstado")
   @Query("SELECT m FROM Municipio m JOIN FETCH m.estado WHERE m.estado.id_estado = :IdEstado")
   Set<Municipio> showMunPorEdo(Integer IdEstado);





    /*@PersistenceContext
    EntityManager entityManager = null;

    public default List<Municipio> showMunPorEdo(Integer id_estado) {
        String sql = "SELECT * FROM municipios WHERE Id_Estados = :id_estado";

        Query query = (Query) entityManager.createNativeQuery(sql, Municipio.class);
        ((jakarta.persistence.Query) query).setParameter("id_estado", id_estado);
        return ((jakarta.persistence.Query) query).getResultList();
    }*/
}
