package com.lhjundi.EnergyMonitoringApplication.controller;

import com.lhjundi.EnergyMonitoringApplication.model.DetailUserDTO;
import com.lhjundi.EnergyMonitoringApplication.model.UpdateUserDTO;
import com.lhjundi.EnergyMonitoringApplication.model.Usuario;
import com.lhjundi.EnergyMonitoringApplication.model.UsuarioDTO;
import com.lhjundi.EnergyMonitoringApplication.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("usuarios")
public class UserController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid UsuarioDTO dto, UriComponentsBuilder uriComponentsBuilder) {
        var usuario = new Usuario(dto);
        repository.save(usuario);
        var uri = uriComponentsBuilder.path("/consertos/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetailUserDTO(usuario));
    }

    @GetMapping
    public ResponseEntity listar(Pageable pagination){
        Page<Usuario> page = repository.findAll(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable Long id) {
        Optional<Usuario> usuarioOptional = repository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            return ResponseEntity.ok(new DetailUserDTO(usuario));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateUserDTO dto){
        Usuario usuario = repository.getReferenceById(dto.id());
        usuario.atualizarInformacoes(dto);
        return ResponseEntity.ok(new DetailUserDTO(usuario));
    }

}
