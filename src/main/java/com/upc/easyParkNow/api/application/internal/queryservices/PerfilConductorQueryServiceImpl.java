package com.upc.easyParkNow.api.application.internal.queryservices;

import com.upc.easyParkNow.api.domain.model.entities.Alquiler;
import com.upc.easyParkNow.api.domain.model.entities.Auto;
import com.upc.easyParkNow.api.domain.model.entities.Conductor;
import com.upc.easyParkNow.api.domain.model.queries.*;
import com.upc.easyParkNow.api.domain.services.PerfilConductorQueryService;
import com.upc.easyParkNow.api.infraestructure.persistence.jpa.repositories.AlquilerRepository;
import com.upc.easyParkNow.api.infraestructure.persistence.jpa.repositories.AutoRepository;
import com.upc.easyParkNow.api.infraestructure.persistence.jpa.repositories.ConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilConductorQueryServiceImpl implements PerfilConductorQueryService {

    @Autowired
    private AutoRepository autoRepository;
    @Autowired
    private ConductorRepository conductorRepository;
    @Autowired
    private AlquilerRepository alquilerRepository;

    @Override
    public List<Auto> handle(GetAllCarsQuery query) {
        return autoRepository.findAll();
    }
    @Override
    public List<Alquiler> handle (GetAllAlquilerQuery query){
        return alquilerRepository.findAll();
    }

    @Override
    public List<Conductor> handle(GetAllConductorsQuery query) {
        return conductorRepository.findAll();
    }

    @Override
    public List<Auto> handle(GetAllCarsFromConductorIdQuery query) {
        return autoRepository.findByConductorId(query.IdConductor());
    }

    @Override
    public List<Alquiler> handle (GetAllAlquilerFromConductorIdQuery query){
       return alquilerRepository.findByConductorId(query.IdConductor());
    }
     @Override
    public List<Alquiler> handle (GetAllAlquilereFromMontoQuery query){
        return  alquilerRepository.findByMonto(query.monto());
     }

}
