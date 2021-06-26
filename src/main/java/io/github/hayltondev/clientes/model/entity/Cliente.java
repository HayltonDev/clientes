package io.github.hayltondev.clientes.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    @NotEmpty(message = "{campo.nome.obrigatorio}") //valida se é null ou vazio //bean validation, especificação java EE
    private String nome;

    @Column(nullable = false, length = 11)
    @NotNull(message = "{campo.cpf.obrigatorio}")
    @CPF(message = "{campo.cpf.invalido}")
    private String cpf;

    @Column(name = "data_cadastro", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy") //formata apenas no retorno do JSON e não é salvo nesse formato do banco
    private LocalDate dataCadastro;

    @PrePersist //antes de persistir no banco a entidade, ele vai executar essa ação
    public void prePersist(){
        setDataCadastro(LocalDate.now());
    }

}
