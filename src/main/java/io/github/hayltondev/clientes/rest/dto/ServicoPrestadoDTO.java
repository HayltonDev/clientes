package io.github.hayltondev.clientes.rest.dto;

import lombok.*;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ServicoPrestadoDTO {

    private String descricao;
    private String preco;
    private String data;
    private Integer idCliente;
}
