package com.upc.easyParkNow.api.application.internal.controller;

import com.upc.easyParkNow.api.domain.model.commands.*;
import com.upc.easyParkNow.api.domain.model.entities.Auto;
import com.upc.easyParkNow.api.domain.model.entities.Conductor;
import com.upc.easyParkNow.api.domain.model.entities.Reclamo;
import com.upc.easyParkNow.api.domain.model.entities.Resenia;
import com.upc.easyParkNow.api.domain.services.PerfilConductorCommandService;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/easyParkNow/perfilConductor")
public class PerfilConductorCommandController {

    @Autowired
    private PerfilConductorCommandService perfilConductorCommandService;

    @Transactional
    @PostMapping("/{idConductor}/autos")
    public ResponseEntity<?> createAuto(@PathVariable Long idConductor, @RequestBody Auto auto){

        return new ResponseEntity<>(perfilConductorCommandService.handle(
                CreateAutoCommand.builder()
                        .idConductor(idConductor)
                        .modelo(auto.getModelo())
                        .placa(auto.getPlaca())
                        .build()
        ), org.springframework.http.HttpStatus.CREATED);
    }

    @Transactional
    @PostMapping("/{idConductor}/reclamos")
    public ResponseEntity<?> createReclamo (@PathVariable Long idConductor, @RequestBody Reclamo reclamo){
        return new ResponseEntity<>(perfilConductorCommandService.handle(
                CreateReclamoCommand.builder()
                        .idConductor(idConductor)
                        .mensaje(reclamo.getMensaje())
                        .build()
        ), org.springframework.http.HttpStatus.CREATED);
    }

    @Transactional
    @PostMapping("/{idConductor}/resenias")
    public ResponseEntity<?> createResenia (@PathVariable Long idConductor, @RequestBody Resenia resenia){
        return new ResponseEntity<>(perfilConductorCommandService.handle(
                CreateReseniaCommand.builder()
                        .idConductor(idConductor)
                        .estrellas(resenia.getCantidadEstrellas())
                        .fechaPublicacion(String.valueOf(resenia.getFechaPublicacion()))
                        .mensaje(resenia.getMensaje())
                        .build()
        ), org.springframework.http.HttpStatus.CREATED);
        
    }

    @Transactional
    @PostMapping("/conductores")
    public ResponseEntity<?> createConductor(@RequestBody Conductor conductor){

        return new ResponseEntity<>(perfilConductorCommandService.handle(
                CreateConductorCommand.builder()
                        .nombre(conductor.getNombre())
                        .edad(conductor.getEdad())
                        .licencia(conductor.getLicencia())
                        .telefono(conductor.getTelefono())
                        .build()
        ), org.springframework.http.HttpStatus.CREATED);
    }

    @Transactional
    @DeleteMapping("/autos/{autoId}")
    public ResponseEntity<?> deleteAuto(@PathVariable Long autoId){

        return new ResponseEntity<>(perfilConductorCommandService.handle(
                DeleteAutoCommand.builder()
                        .idAuto(autoId)
                        .build()
        ),org.springframework.http.HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/reclamos/{reclamoId}")
    public ResponseEntity<?> deleteReclamo(@PathVariable Long reclamoId){
        return new ResponseEntity<>(perfilConductorCommandService.handle(
                DeleteReclamoCommand.builder()
                        .idReclamo(reclamoId)
                        .build()
        ),org.springframework.http.HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/resenias/{reseniaId}")
    public ResponseEntity<?> deleteResenia(@PathVariable Long reseniaId){
        return new ResponseEntity<>(perfilConductorCommandService.handle(
                DeleteReseniaCommand.builder()
                        .idResenia(reseniaId)
                        .build()
        ),org.springframework.http.HttpStatus.OK);
    }

    @Transactional
    @PutMapping("/actualizar/{modelo}")
    public ResponseEntity<?> updateModeloAuto(@PathVariable String modelo){
        return new ResponseEntity<>(perfilConductorCommandService.handle(
                UpdateModeloAutoCommand.builder()
                        .modelo(modelo)
                        .build()
        ),HttpStatus.OK);
    }

    @Transactional
    @PutMapping("/actualizar/{mensaje}")
    public ResponseEntity<?> updateDescriptionResenia (@PathVariable String mensaje){
        return new ResponseEntity<>(perfilConductorCommandService.handle(
                UpdateDescriptionReseniaCommand.builder()
                        .mensaje(mensaje)
                        .build()
        ),HttpStatus.OK);
    }

    @Transactional
    @PutMapping("/actualizar/{mensajes}")
    public ResponseEntity<?> updateReclamo (@PathVariable String mensajes){
        return new ResponseEntity<>(perfilConductorCommandService.handle(
                UpdateReclamoCommand.builder()
                        .mensaje(mensajes)
                        .build()
        ),HttpStatus.OK);
    }




}
