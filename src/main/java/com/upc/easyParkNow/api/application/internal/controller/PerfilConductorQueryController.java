package com.upc.easyParkNow.api.application.internal.controller;

import com.upc.easyParkNow.api.domain.model.queries.*;
import com.upc.easyParkNow.api.domain.services.PerfilConductorCommandService;
import com.upc.easyParkNow.api.domain.services.PerfilConductorQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/perfilConductor")
public class PerfilConductorQueryController {

    @Autowired
    private PerfilConductorQueryService perfilConductorQueryService;

    @Transactional
    @GetMapping("/autos")
    public ResponseEntity<?> getAllAutos(){
        return new ResponseEntity<>(perfilConductorQueryService.handle(
                new GetAllCarsQuery()
        ), org.springframework.http.HttpStatus.OK);
    }

    @Transactional
    @GetMapping("/conductores")
    public ResponseEntity<?> getAllConductores(){
        return new ResponseEntity<>(perfilConductorQueryService.handle(
                new GetAllConductorsQuery()
        ), org.springframework.http.HttpStatus.OK);
    }
    @Transactional
    @GetMapping("/alquileres")
    public ResponseEntity<?> getAllAlquileres(){
        return new ResponseEntity<>(perfilConductorQueryService.handle(
                new GetAllAlquilerQuery()
        ), org.springframework.http.HttpStatus.OK);
    }

    @Transactional
    @GetMapping("{idConductor}/autos")
    public ResponseEntity<?> getAllAutosFromConductorId(@PathVariable Long idConductor){
        return new ResponseEntity<>(perfilConductorQueryService.handle(
                new GetAllCarsFromConductorIdQuery(idConductor)
        ), org.springframework.http.HttpStatus.OK);
    }

    @Transactional
    @GetMapping("{idConductor}/alquileres")
    public ResponseEntity<?> getAllAlquilerFromConductorId(@PathVariable Long idConductor){
        return new ResponseEntity<>(perfilConductorQueryService.handle(
                new GetAllAlquilerFromConductorIdQuery(idConductor)
        ),org.springframework.http.HttpStatus.OK);
    }

    @Transactional
    @GetMapping("{monto}/alquiler")
    public ResponseEntity<?> getAllAlquilerFromMonto(@PathVariable Float monto){
        return new ResponseEntity<>(perfilConductorQueryService.handle(
                new GetAllAlquilereFromMontoQuery(monto)
        ),org.springframework.http.HttpStatus.OK);
    }

}
