package io.github.hayltondev.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //annotation que indica que a classe deve inicializar a aplicação e definio o scaneamento de classes abaixo dela automaticamente e injeção de dependencias
public class ClientesApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientesApplication.class,args);
    }
}
