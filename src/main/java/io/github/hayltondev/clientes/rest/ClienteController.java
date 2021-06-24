package io.github.hayltondev.clientes.rest;


import io.github.hayltondev.clientes.model.entity.Cliente;
import io.github.hayltondev.clientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public Cliente salvar(@RequestBody Cliente cliente){ //@RequestBody indica que é JSON body que veio do corpo da requisição, o json montado do postaman por exemplo
        return repository.save(cliente);
    }

    @GetMapping("{id}")
    public Cliente bucarPorId(@PathVariable("id") Integer id){ //posso omitir o "id" do pathVariable por ser o mesmo identificador do atributo Integer id
        return repository.findById(id).orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND)); //supplier java
        //se encontrar o cliente ele irá retornar, caso contrário irá retornar a exception notfound
    }
}
