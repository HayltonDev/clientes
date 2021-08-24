package io.github.hayltondev.clientes.rest;


import io.github.hayltondev.clientes.model.entity.Usuario;
import io.github.hayltondev.clientes.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private void salvar(@RequestBody @Valid Usuario usuario){
        repository.save(usuario);
    }

}
