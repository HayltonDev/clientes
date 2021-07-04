package io.github.hayltondev.clientes.repository;

import io.github.hayltondev.clientes.model.entity.ServicoPrestado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Integer> {
}
