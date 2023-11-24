package com.upc.easyParkNow.api.domain.exceptions;

public class ReclamoNotFoundException extends RuntimeException{
    public ReclamoNotFoundException(Long idConductor) {
        super("Conductor con el id " + idConductor + " no ha sido encontrado");
    }
}
