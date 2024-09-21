package lucasgodoy1.com.github.nakedapi.entity;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import lucasgodoy1.com.github.nakedapi.constants.Estado;
import lucasgodoy1.com.github.nakedapi.constants.UF;

import java.io.Serializable;

@Entity
@RequiredArgsConstructor
@Table(name = "tb_endereco")
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "endereco_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente clienteID;

    @Column(name="rua", nullable=false)
    private String rua;

    @Column(name="numero", nullable=false, length=5)
    private String numero;

    @Column(name="cep", nullable=false, length=8)
    private String cep;

    @Column(name="bairro")
    private String bairro;

    @Column
    private String complemento;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Enumerated(EnumType.STRING)
    private UF uf;


}
