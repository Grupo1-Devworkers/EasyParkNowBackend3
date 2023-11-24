package com.upc.easyParkNow.api.domain.model.commands;

import lombok.Builder;

@Builder
public record CreateReclamoCommand
        (long idConductor, String mensaje) {
}
