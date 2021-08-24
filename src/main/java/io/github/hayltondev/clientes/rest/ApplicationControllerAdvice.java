package io.github.hayltondev.clientes.rest;

import io.github.hayltondev.clientes.rest.exception.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

//é uma classe que serve para interceptar os erros depois da requisição e tratar o retorno para o cliente que fez a requisição
@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler({MethodArgumentNotValidException.class}) //através dessa anotation intercepta esse tipo de exeption em expecifico
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationErros(MethodArgumentNotValidException ex){ //o argumento aqui ele captura a exception da vez
        BindingResult bindingResult = ex.getBindingResult();
        List<String> erros = bindingResult.getAllErrors()
                .stream()
                .map( objectError -> objectError.getDefaultMessage())
                .collect(Collectors.toList());
        return new ApiErrors(erros);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity handleResponseStatusException(ResponseStatusException ex){
        String menssageError = ex.getReason();
        HttpStatus codigoStatus = ex.getStatus();
        ApiErrors apiErrors = new ApiErrors(menssageError);
        return new ResponseEntity(apiErrors, codigoStatus);
    }
}
