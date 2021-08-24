package io.github.hayltondev.clientes.repository;

import io.github.hayltondev.clientes.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    //queryMethod
    Optional<Usuario> findByUsername(String username);

    boolean existsByUsername(String username);
}
