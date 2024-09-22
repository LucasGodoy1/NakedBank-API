package lucasgodoy1.com.github.nakedapi.dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lucasgodoy1.com.github.nakedapi.constants.Estado;
import lucasgodoy1.com.github.nakedapi.constants.TipoConta;
import lucasgodoy1.com.github.nakedapi.constants.UF;

public record CadastroDTO(
        //Entity Login
        @NotBlank String cpf, @NotBlank @Email String email, @NotBlank String password,

        //Entity Cliente
        @NotBlank String nomeCompleto, @NotBlank String nacionalidade, @NotBlank String telefone,

        //Entity endereco
        @NotBlank String rua, @NotBlank String numero, @NotBlank String cep, @NotBlank String bairro,
        String complemento, @NotNull Estado estado, @NotNull UF uf,

        //entity conta
        @NotBlank String numeroAgencia, @NotBlank String nome, @NotNull TipoConta tipoDaConta



) {


        }
