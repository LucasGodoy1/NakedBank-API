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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTA_ID")
    @JsonBackReference
    private Conta conta;

    @Override
    public String toString() {
        return "Extrato: " +
                nomeDaTransacao + "\n" +
                String.format("R$: %.2f", valor) + "\n" +
                "DATA: " + dataDaCompra;
    }
}

