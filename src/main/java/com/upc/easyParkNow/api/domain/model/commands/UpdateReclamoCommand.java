package com.upc.easyParkNow.api.domain.model.commands;

import lombok.Builder;

@Builder
public record UpdateReclamoCommand
        (Long idReclamo, String mensaje) {
}
