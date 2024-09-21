package lucasgodoy1.com.github.nakedapi.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lucasgodoy1.com.github.nakedapi.constants.TipoConta;

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
    @Column(name = "numero_conta")
    private String numeroDaConta;

    @Column(name = "numero_agencia")
    private String numeroAgencia ;


    @Column(name = "saldo")
    private Double saldo = 0.0;

    @Column(name = "nome")
    private String nomeCompleto;

    @Column(name = "tipo_conta")
    @Enumerated(EnumType.STRING)
    private TipoConta tipoDaConta;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente clienteID;


}
