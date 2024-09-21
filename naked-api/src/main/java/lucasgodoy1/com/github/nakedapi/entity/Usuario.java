package lucasgodoy1.com.github.nakedapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lucasgodoy1.com.github.nakedapi.dto.CadastroDTO;
import lucasgodoy1.com.github.nakedapi.hash.HashLogin;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter @Setter @ToString
@RequiredArgsConstructor
@Entity
@Table(name="tb_usuario")
public class Usuario implements Serializable {
    @Id
    @Column(name="cpf", nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="password", nullable = false, length = 200)
    private String password;

    @Column(name= "data_criacao")
    private LocalDateTime dataCriacao = LocalDateTime.now();




    public Usuario(CadastroDTO cadastro) {
        this.cpf = cadastro.cpf();
        this.email = cadastro.email();
        this.password = HashLogin.encoder(cadastro.password());
    }

}
