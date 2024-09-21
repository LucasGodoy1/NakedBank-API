package lucasgodoy1.com.github.nakedapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Table(name = "tb_extrato")
public class Extrato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "extrato_id")
    private Long id;

    @Column(name = "NOME_TRANSACAO")
    private String nomeDaTransacao;

    @Column(name = "VALOR")
    private Double valor;

    @Column(name = "DATA_COMPRA")
    private LocalDateTime dataDaCompra = LocalDateTime.now();

    public Extrato(String nomeDaTransacao, Double valor) {
        this.nomeDaTransacao = nomeDaTransacao;
        this.valor = valor;
    }

    @ManyToOne
    @JoinColumn(name = "numero_conta")
    private Conta contaID;

    @Override
    public String toString() {
        return "Extrato: " +
                nomeDaTransacao + "\n" +
                String.format("R$: %.2f", valor) + "\n" +
                "DATA: " + dataDaCompra;
    }
}

