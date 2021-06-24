package io.github.hayltondev.clientes;

import io.github.hayltondev.clientes.model.entity.Cliente;
import io.github.hayltondev.clientes.repository.ClienteRepository;
import org.h2.command.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication //annotation que indica que a classe deve inicializar a aplicação e definio o scaneamento de classes abaixo dela automaticamente e injeção de dependencias
public class ClientesApplication {

   /* @Bean
    public CommandLineRunner exec(@Autowired ClienteRepository clienteRepository){
        return args -> {
            Cliente cliente = Cliente.builder().cpf("12345678910").nome("Haylton").build();
            clienteRepository.save(cliente);
        };
    }*/

    public static void main(String[] args) {
        SpringApplication.run(ClientesApplication.class,args);
    }
}
