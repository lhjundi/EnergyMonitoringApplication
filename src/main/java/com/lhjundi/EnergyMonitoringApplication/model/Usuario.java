package com.lhjundi.EnergyMonitoringApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String senha;
    private double consumomax;

    public Usuario(UsuarioDTO dto) {
        this.nome = dto.nome();
        this.senha = dto.senha();
        this.consumomax = dto.consumomax();
    }

    public void atualizarInformacoes(UpdateUserDTO dto) {
        Optional<String> nome = Optional.ofNullable(dto.nome());
        Optional<String> senha = Optional.ofNullable(dto.senha());
        Optional<Double> consumomax = Optional.of(dto.consumomax());
        nome.ifPresent( s -> this.nome = s);
        senha.ifPresent( s -> this.senha = s);
        consumomax.ifPresent( s -> this.consumomax = s);
    }
}
