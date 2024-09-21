package lucasgodoy1.com.github.nakedapi.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lucasgodoy1.com.github.nakedapi.dto.CadastroDTO;

import java.io.Serializable;

@Getter @Setter @ToString
@RequiredArgsConstructor
@Entity
@Table(name="tb_cliente")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "cpf", referencedColumnName = "cpf")
    private Usuario cpf;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco enderecoID;

    @Column(name="nome", nullable = false)
    private String nomeCompleto;

    @Column(name="nacionalidade")
    private String nacionalidade;

    @Column(name = "telefone", length = 15)
    private String telefone;

    public Cliente(CadastroDTO cadastro) {
        this.nomeCompleto = cadastro.nomeCompleto();
        this.nacionalidade = cadastro.nacionalidade();
        this.telefone = cadastro.telefone();
    }

}
