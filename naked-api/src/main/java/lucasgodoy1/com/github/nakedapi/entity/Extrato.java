package lucasgodoy1.com.github.nakedapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;


@ToString
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

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "conta_id")
    private Conta contaID;

    public Extrato(String nomeDaTransacao, Double valor, Conta contaID) {
        this.nomeDaTransacao = nomeDaTransacao;
        this.valor = valor;
        this.contaID = contaID;
    }




}

