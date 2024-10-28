package com.lhjundi.EnergyMonitoringApplication.model;

public record UsuarioDTO(
        String id,
        String email,
        String nome,
        String senha,
        double consumomax) {
}
