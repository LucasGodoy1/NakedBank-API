package lucasgodoy1.com.github.nakedapi.service;

import lombok.RequiredArgsConstructor;
import lucasgodoy1.com.github.nakedapi.dto.CadastroDTO;
import lucasgodoy1.com.github.nakedapi.entity.Cliente;
import lucasgodoy1.com.github.nakedapi.entity.Conta;
import lucasgodoy1.com.github.nakedapi.entity.Endereco;
import lucasgodoy1.com.github.nakedapi.entity.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CadastroService {
    private final ContaService contaService;
    private final ClienteService clienteService;
    private final EnderecoService enderecoService;
    private final UsuarioService usuarioService;

    @Transactional
    public void cadastroInicial(CadastroDTO cadastroDTO) {

        var usuario = new Usuario(cadastroDTO);
        usuarioService.salvar(usuario);


        var cliente = new Cliente(cadastroDTO);
        cliente.setCpf(usuario);
        clienteService.salvar(cliente);


        var endereco = new Endereco(cadastroDTO);
        endereco.setClienteID(cliente);
        enderecoService.salvarDados(endereco);


        cliente.setEnderecoID(endereco);
        clienteService.salvar(cliente);


        var conta = new Conta(cadastroDTO);
        conta.setClienteID(cliente);
        contaService.salvar(conta);
    }

}
