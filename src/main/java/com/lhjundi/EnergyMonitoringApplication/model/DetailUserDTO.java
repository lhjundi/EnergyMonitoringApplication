package com.lhjundi.EnergyMonitoringApplication.model;

public record DetailUserDTO(
        Long id,
        String email,
        double consumomax
) {
    public DetailUserDTO(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getConsumomax()
        );
    }
}
