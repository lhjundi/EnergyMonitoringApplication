package com.lhjundi.EnergyMonitoringApplication.repository;

import com.lhjundi.EnergyMonitoringApplication.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
