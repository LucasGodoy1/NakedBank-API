package lucasgodoy1.com.github.nakedapi.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter @Setter @ToString
@RequiredArgsConstructor
@Entity
@Table(name="tb_dados_endereco")
public class Endereco implements Serializable {

    @Id
    @Column(name="cpf", nullable = false, unique = true, length = 200)
    private Long cpf;

    @Column(name="nome", nullable = false)
    private String nomeCompleto;

    @Column(name="rua")
    private String rua;

    @Column(name="telefone")
    private String telefone;

    @Column(name="cep")
    private String cep;

    @Column(name="bairro")
    private String bairro;

    @Column(name="nacionalidade")
    private String nacionalidade;

}
