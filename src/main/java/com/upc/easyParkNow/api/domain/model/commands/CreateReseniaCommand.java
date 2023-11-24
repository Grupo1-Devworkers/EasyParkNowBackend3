package com.upc.easyParkNow.api.domain.model.commands;

import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;

@Builder
public record CreateReseniaCommand
        (long idConductor, float estrellas, String fechaPublicacion, String mensaje) {
}
