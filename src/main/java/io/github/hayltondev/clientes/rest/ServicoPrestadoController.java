package io.github.hayltondev.clientes.rest;

import io.github.hayltondev.clientes.model.entity.Cliente;
import io.github.hayltondev.clientes.model.entity.ServicoPrestado;
import io.github.hayltondev.clientes.repository.ClienteRepository;
import io.github.hayltondev.clientes.repository.ServicoPrestadoRepository;
import io.github.hayltondev.clientes.rest.dto.ServicoPrestadoDTO;
import io.github.hayltondev.clientes.util.UtilBigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/servicos-prestados")
@RequiredArgsConstructor //irá criar um construtor com todos os atributos final
public class ServicoPrestadoController {

    private final ClienteRepository clienteRepository;

    private final ServicoPrestadoRepository repository;

    private final UtilBigDecimal utilBigDecimal;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar(@RequestBody ServicoPrestadoDTO dto){

        Cliente cliente = clienteRepository.findById(dto.getIdCliente())
                .orElseThrow(()->
                                new ResponseStatusException(
                                        HttpStatus.BAD_REQUEST, "Cliente não encontrado"));

        ServicoPrestado servicoPrestado =
                ServicoPrestado.builder().
                        data(LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                        .descricao(dto.getDescricao())
                        .valor(utilBigDecimal.converter(dto.getPreco()))
                        .cliente(cliente).build();
        return repository.save(servicoPrestado);

    }

    @GetMapping
    public List<ServicoPrestado> findByNomeClienteAndMes(@RequestParam(value = "nome", required = false, defaultValue = "") String nome,
                                                         @RequestParam(value = "mes", required = false, defaultValue = "") Integer mes ){
        return repository.findByNomeClienteAndMes("%"+nome+ "%", mes);
    }




}
