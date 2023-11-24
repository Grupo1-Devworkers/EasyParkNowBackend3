package com.upc.easyParkNow.api.domain.services;

import com.upc.easyParkNow.api.domain.model.commands.*;
import com.upc.easyParkNow.api.domain.model.entities.Auto;
import com.upc.easyParkNow.api.domain.model.entities.Conductor;
import com.upc.easyParkNow.api.domain.model.entities.Reclamo;
import com.upc.easyParkNow.api.domain.model.entities.Resenia;

public interface PerfilConductorCommandService {
        //PerfilConductorCommandService implementacion Create delete update
        //COMMAND SERVICE

        Auto handle(CreateAutoCommand command);
        Reclamo handle (CreateReclamoCommand command);

        Resenia handle (CreateReseniaCommand command);

        String handle(DeleteAutoCommand command);

        String handle (DeleteReclamoCommand command);
        String handle (DeleteReseniaCommand command);

        Conductor handle(CreateConductorCommand command);

        Auto handle(UpdateModeloAutoCommand command);

        Resenia handle (UpdateDescriptionReseniaCommand command);

        Reclamo handle (UpdateReclamoCommand command);








}
