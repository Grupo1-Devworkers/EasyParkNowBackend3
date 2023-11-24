package com.upc.easyParkNow.api.domain.services;

import com.upc.easyParkNow.api.domain.model.entities.Alquiler;
import com.upc.easyParkNow.api.domain.model.entities.Auto;
import com.upc.easyParkNow.api.domain.model.entities.Conductor;
import com.upc.easyParkNow.api.domain.model.queries.*;

import java.util.List;

public interface PerfilConductorQueryService {
    //perfilconductorqueryservice implementacion GET
    //QUERY SERVICE
    List<Auto> handle(GetAllCarsQuery query);

    List<Conductor> handle(GetAllConductorsQuery query);

    List<Auto> handle(GetAllCarsFromConductorIdQuery query);

    List<Alquiler> handle (GetAllAlquilerQuery query);

    List<Alquiler> handle (GetAllAlquilerFromConductorIdQuery query);
    List<Alquiler> handle (GetAllAlquilereFromMontoQuery query);


}
