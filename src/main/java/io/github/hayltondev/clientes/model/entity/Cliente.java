package io.github.hayltondev.clientes.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data //contém já os getters and setter. constructors and hashcod and equals
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // = GenerationType.IDENTITY o banco que vai fazer o autoincremento da forma dele
    private Integer id;
    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(name = "data_cadastro")
    @JsonFormat(pattern = "dd/MM/yyyy") //formata apenas no retorno do JSON e não é salvo nesse formato do banco
    private LocalDate dataCadastro;

    @PrePersist //antes de persistir no banco a entidade, ele vai executar essa ação
    public void prePersist(){
        setDataCadastro(LocalDate.now());
    }

}
