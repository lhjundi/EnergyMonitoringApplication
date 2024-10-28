package com.lhjundi.EnergyMonitoringApplication.model;

import jakarta.validation.constraints.NotNull;

public record UpdateUserDTO(
        @NotNull
        Long id,
        String nome,
        String senha,
        double consumomax
) {
}
