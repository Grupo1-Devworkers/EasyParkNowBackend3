package com.upc.easyParkNow.api.domain.model.commands;

import lombok.Builder;

@Builder
public record UpdateDescriptionReseniaCommand
        (Long idResenia, String mensaje) {
}
