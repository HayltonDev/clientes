package io.github.hayltondev.clientes.rest;


import io.github.hayltondev.clientes.model.entity.Cliente;
import io.github.hayltondev.clientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes") //serve para mapear a url base que serve para identificar esse controller
public class ClienteController {

    private final ClienteRepository repository;

    @Autowired
    public ClienteController(ClienteRepository repository){
        this.repository = repository;
    }

    @PostMapping //indica que vamos criar um recurso no servidor quando mandado a requisicao
    @ResponseStatus(HttpStatus.CREATED) //se não colocar essa anotation, por padrao retornara status OK, ai não segue abordagem RESTFull
    public Cliente salvar(Cliente cliente){
        return repository.save(cliente);
    }
}
