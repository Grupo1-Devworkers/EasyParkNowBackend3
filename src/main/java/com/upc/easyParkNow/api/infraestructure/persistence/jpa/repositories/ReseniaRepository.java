package com.upc.easyParkNow.api.infraestructure.persistence.jpa.repositories;

import com.upc.easyParkNow.api.domain.model.entities.Resenia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReseniaRepository extends JpaRepository<Resenia, Long > {
    boolean existsById(Long conductorId);
    List<Resenia> findByConductorId (Long conductorId);
    boolean existsByCantidadEstrellas(Float cantidad_estrellas);
    List<Resenia> findByCantidadEstrellas (Float estrellas);

}