package com.upc.easyParkNow.api.infraestructure.persistence.jpa.repositories;

import com.upc.easyParkNow.api.domain.model.entities.Alquiler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler,Float> {
    boolean existsAlquilerByMonto (Float monto);
    List<Alquiler> findByMonto(Float Monto);

    boolean existsById (Long id);
    List<Alquiler> findByConductorId(Long conductorId);

}
