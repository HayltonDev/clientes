package io.github.hayltondev.clientes.repository;

import io.github.hayltondev.clientes.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
