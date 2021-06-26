package io.github.hayltondev.clientes.rest;


import io.github.hayltondev.clientes.model.entity.Cliente;
import io.github.hayltondev.clientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

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
    //@valid estou falando para o spring no momento da requisição fazer aquelas validações de notNull, notEmpty de beans validator com mensagens customizaadas que criei de internacionalizacao
    public Cliente salvar(@RequestBody @Valid Cliente cliente){ //@RequestBody indica que é JSON body que veio do corpo da requisição, o json montado do postaman por exemplo. com
        return repository.save(cliente);
    }

    @GetMapping("{id}")
    public Cliente bucarPorId(@PathVariable("id") Integer id){ //posso omitir o "id" do pathVariable por ser o mesmo identificador do atributo Integer id
        return repository.findById(id).orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!")); //supplier java
        //se encontrar o cliente ele irá retornar, caso contrário irá retornar a exception notfound
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //NO_CONTENT não nada para o servidor retornar, porém deu certo a execução feita pela requisição do client para o servidor
    public void deletar(@PathVariable Integer id){
         repository.findById(id)
                .map( cliente -> {
                    repository.delete(cliente);
                    return Void.TYPE; //por conta de que o map pode retornar tanto cliente quanto null para não cair ali no orElseThrow
                })
                .orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!") );
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id, @RequestBody @Valid Cliente clienteAtualizado){
        repository.findById(id)
                .map( cliente -> {
                    clienteAtualizado.setId(cliente.getId());
                    repository.save(clienteAtualizado);
                    return clienteAtualizado;
                }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));

    }

}
