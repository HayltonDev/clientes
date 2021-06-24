package io.github.hayltondev.clientes.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data //contém já os getters and setter. constructors and hashcod and equals
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // = GenerationType.IDENTITY o banco que vai fazer o autoincremento da forma dele
    private Integer id;
    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;


}
