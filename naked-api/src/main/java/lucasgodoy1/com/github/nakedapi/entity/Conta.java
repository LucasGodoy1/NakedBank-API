package lucasgodoy1.com.github.nakedapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lucasgodoy1.com.github.nakedapi.service.ContaService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Table(name = "tb_conta")
public class Conta implements Serializable {

    @Id
    @Column(name = "NUMERO_CONTA")
    private String numeroDaConta = ContaService.geraNumeroConta(1, 10, 7);

    @Column(name = "NUMERO_AGENCIA")
    private String numeroAgencia = ContaService.geraNumeroConta(1, 10, 5);

    @Column(name = "SALDO")
    private Double saldo = 0.0;

    @Column(name = "NOME")
    private String nomeCompleto;

    @Column(name = "TIPO_CONTA")
    private TipoConta tipoDaConta;

    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Extrato> extratoList = new ArrayList<>();

    @Override
    public String toString() {
        return  "Conta: "
                + numeroDaConta + "\n" +
                "Agencia: "
                + numeroAgencia
                + "\n"
                + String.format("Saldo: R$: %.2f", saldo)
                + "\n"
                + " Nome: "
                + nomeCompleto
                + "\n" +
                "Tipo: " + tipoDaConta
                + "\n"
                + "Extrato: "
                + extratoList;
    }
}
