package lucasgodoy1.com.github.nakedapi.dto;


import lucasgodoy1.com.github.nakedapi.constants.Estado;
import lucasgodoy1.com.github.nakedapi.constants.TipoConta;
import lucasgodoy1.com.github.nakedapi.constants.UF;

public record CadastroDTO(
        //Entity Login
        String cpf, String email, String password,

        //Entity Cliente
        String nomeCompleto, String nacionalidade, String telefone,

        //Entity endereco
        String rua, String numero,String cep,String bairro,
        String complemento, Estado estado, UF uf,

        //entity conta
        String numeroAgencia, String nome, TipoConta tipoDaConta



) {


        }
