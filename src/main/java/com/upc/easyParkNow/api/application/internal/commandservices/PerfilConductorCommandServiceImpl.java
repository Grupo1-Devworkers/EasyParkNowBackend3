package com.upc.easyParkNow.api.application.internal.commandservices;

import com.upc.easyParkNow.api.domain.exceptions.ConductorNotFoundException;
import com.upc.easyParkNow.api.domain.exceptions.ReclamoNotFoundException;
import com.upc.easyParkNow.api.domain.exceptions.ReseniaNotFoundException;
import com.upc.easyParkNow.api.domain.exceptions.ValidationException;
import com.upc.easyParkNow.api.domain.model.commands.*;
import com.upc.easyParkNow.api.domain.model.entities.Auto;
import com.upc.easyParkNow.api.domain.model.entities.Conductor;
import com.upc.easyParkNow.api.domain.model.entities.Reclamo;
import com.upc.easyParkNow.api.domain.model.entities.Resenia;
import com.upc.easyParkNow.api.domain.services.PerfilConductorCommandService;
import com.upc.easyParkNow.api.infraestructure.persistence.jpa.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilConductorCommandServiceImpl implements PerfilConductorCommandService {

    @Autowired
    private AutoRepository autoRepository;

    @Autowired
    private ConductorRepository conductorRepository;
    @Autowired
    private AlquilerRepository alquilerRepository;
    @Autowired
    private ReclamoRepository reclamoRepository;
    @Autowired
    private ReseniaRepository reseniaRepository;




    @Override
    public Auto handle(CreateAutoCommand command) {

        Long idConductor=command.idConductor();

        if(!conductorRepository.existsById(idConductor)){
            throw new ConductorNotFoundException(command.idConductor());
        }

        Auto auto = new Auto();
        auto.setConductor(conductorRepository.findById(idConductor).get());
        auto.setModelo(command.modelo());
        auto.setPlaca(command.placa());

        return autoRepository.save(auto);
    }
    @Override
    public Reclamo handle(CreateReclamoCommand command){
        Long idConductor=command.idConductor();
        if (!reclamoRepository.existsById(idConductor)){
            throw new ReclamoNotFoundException(command.idConductor());
        }
        Reclamo reclamo=new Reclamo();
        reclamo.setConductor(conductorRepository.findById(idConductor).get());
        reclamo.setMensaje(command.mensaje());

        return reclamoRepository.save(reclamo);
    }

    @Override
    public Resenia handle(CreateReseniaCommand command){
        Long idConductor = command.idConductor();
        if(!reseniaRepository.existsById(idConductor)){
            throw new ReseniaNotFoundException(command.idConductor());
        }
        Resenia resenia=new Resenia();
        resenia.setConductor(conductorRepository.findById(idConductor).get());
        resenia.setCantidadEstrellas(command.estrellas());
        resenia.setFechaPublicacion(command.fechaPublicacion());
        resenia.setMensaje(command.mensaje());

        return reseniaRepository.save(resenia);
    }

    @Override
    public String handle(DeleteAutoCommand command) {

        if(!autoRepository.existsById(command.idAuto())){
            throw new ValidationException( "El auto con el id " + command.idAuto() + " no existe");
        }
        autoRepository.deleteById(command.idAuto());
        return "El auto con el id " + command.idAuto() + " ha sido eliminado";
    }

    @Override
    public String handle(DeleteReclamoCommand command){
        if (!reclamoRepository.existsById(command.idReclamo())){
            throw new ValidationException("El reclamo con el id"+ command.idReclamo() + "no existe");
        }
        reclamoRepository.deleteById(command.idReclamo());
        return "El reclamo con el id" + command.idReclamo() + "ha sido eliminado";
    }

    @Override
    public String handle (DeleteReseniaCommand command){
        if(!reseniaRepository.existsById(command.idResenia())){
            throw new ValidationException("La reseña con el id" + command.idResenia() + "no existe");
        }
        reseniaRepository.deleteById(command.idResenia());
        return "La reseña con el id" + command.idResenia() + "ha sido eliminado";
    }

    @Override
    public Conductor handle(CreateConductorCommand command) {

        Conductor conductor = new Conductor();
        conductor.setNombre(command.nombre());
        conductor.setEdad(command.edad());
        conductor.setLicencia(command.licencia());
        conductor.setTelefono(command.telefono());


        return conductorRepository.save(conductor);
    }

    @Override
    public Auto handle(UpdateModeloAutoCommand command) {

            if(!autoRepository.existsById(command.idAuto())){
                throw new ValidationException( "El auto con el id " + command.idAuto() + " no existe");
            }

            Auto auto = autoRepository.findById(command.idAuto()).get();
            auto.setModelo(command.modelo());

            return autoRepository.save(auto);
    }

    @Override
    public Resenia handle(UpdateDescriptionReseniaCommand command)  {
        if(!reseniaRepository.existsById(command.idResenia())){
            throw new ValidationException("La reseña con el id" + command.idResenia() + "no existe");
        }
        Resenia resenia = reseniaRepository.findById(command.idResenia()).get();
        resenia.setMensaje(command.mensaje());

        return reseniaRepository.save(resenia);
    }
    //UpdateMensaje
    @Override
    public Reclamo handle(UpdateReclamoCommand command){
        if (!reclamoRepository.existsById(command.idReclamo())){
            throw new ValidationException("El reclamo con el id" +command.idReclamo() + "no existe");
        }
        Reclamo reclamo = reclamoRepository.findById(command.idReclamo()).get();
        reclamo.setMensaje(command.mensaje());

        return reclamoRepository.save(reclamo);

    }


}
