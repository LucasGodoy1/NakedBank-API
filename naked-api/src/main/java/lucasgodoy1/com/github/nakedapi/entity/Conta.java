package lucasgodoy1.com.github.nakedapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lucasgodoy1.com.github.nakedapi.constants.TipoConta;
import lucasgodoy1.com.github.nakedapi.dto.CadastroDTO;
import lucasgodoy1.com.github.nakedapi.service.NumerosAleatorios;

import java.io.Serializable;


@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Table(name = "tb_conta")
public class Conta implements Serializable {

    @Id
    @Column(name = "conta_id")
    private String numeroDaConta;

    @Column(name = "numero_agencia")
    private String numeroAgencia ;

    @Column(name = "saldo", columnDefinition = "DECIMAL(19, 2)")
    private double saldo = 0.00;

    @Column(name = "nome")
    private String nomeCompleto;

    @Column(name = "tipo_conta")
    @Enumerated(EnumType.STRING)
    private TipoConta tipoDaConta;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente clienteID;

    public Conta(CadastroDTO cadastroDTO) {
        this.numeroDaConta = NumerosAleatorios.geraNumeroConta(1,9,7);
        this.numeroAgencia = cadastroDTO.numeroAgencia();
        this.nomeCompleto = cadastroDTO.nomeCompleto();
        this.tipoDaConta = cadastroDTO.tipoDaConta();
    }
}
