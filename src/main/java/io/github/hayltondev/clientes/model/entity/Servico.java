package io.github.hayltondev.clientes.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String descricao;

    @ManyToOne //Many "muitos " Servicos.class To "para" One "Um" Cliente.class
    @JoinColumn(name = "id_cliente") //join column define a chave extrangeira de clientes em servico
    private Cliente cliente;

    @Column
    private BigDecimal valor;

}
