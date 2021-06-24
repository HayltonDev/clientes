package io.github.hayltondev.clientes.repository;

import io.github.hayltondev.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository  extends JpaRepository<Cliente, Integer> {
}
