package com.upc.easyParkNow.api.domain.exceptions;

public class ReseniaNotFoundException extends RuntimeException{
    public ReseniaNotFoundException (Long idConductor){
        super("Conductor con el id " + idConductor + " no ha sido encontrado");
    }
}
