package lucasgodoy1.com.github.nakedapi.controller;

import lombok.RequiredArgsConstructor;
import lucasgodoy1.com.github.nakedapi.entity.Conta;
import lucasgodoy1.com.github.nakedapi.entity.Endereco;
import lucasgodoy1.com.github.nakedapi.entity.Usuario;
import lucasgodoy1.com.github.nakedapi.service.ContaService;
import lucasgodoy1.com.github.nakedapi.service.DadosPessoaisService;
import lucasgodoy1.com.github.nakedapi.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//TODO: corrigir url tornando um paddrão de nomes
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/nakedBank")
public class WebController {
    private final UsuarioService usuarioService;
    private final DadosPessoaisService dadosPessoaisService;
    private final ContaService contaService;



    @PostMapping("/create")
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
        String senhaCodificada =  ContaService.encoder(usuario.getPassword());
        usuario.setPassword(senhaCodificada);

        usuarioService.salvar(usuario);
        usuario.setPassword("*****");
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
    @PostMapping("/createlista")
    public ResponseEntity<List<Usuario>> createlista(@RequestBody List<Usuario> usuarios){
        usuarioService.salvarVarios(usuarios);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarios);
    }


    @GetMapping("/dadosID={id}")
    public ResponseEntity<Usuario> dadosCompleto(@PathVariable Long id){
        Usuario u = usuarioService.encontrePorID(id);
        return ResponseEntity.ok().body(u);
    }

    @GetMapping("/buscarID={id}")
    public ResponseEntity<Usuario> buscarPorCPF(@PathVariable Long id){
        Usuario u = usuarioService.encontrePorID(id);
        u.setPassword("*****");
        return ResponseEntity.ok().body(u);
    }

    @PatchMapping("/alterarSenha/id={id}")
    public ResponseEntity<String> alterarSenha(@PathVariable Long id, @RequestBody Usuario usuario){
        usuarioService.alterarSenha(id, ContaService.encoder(usuario.getPassword()));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/usuariosCadastrados")
    public ResponseEntity<List<Usuario>> cadastro(){
        List<Usuario> l = usuarioService.listaDeCadastros();
        l.forEach(usuario -> usuario.setPassword("******"));
        return ResponseEntity.ok().body(l);
    }

    @DeleteMapping("/deleteID={id}")
    public ResponseEntity<Usuario> deletarPorID(@PathVariable Long id){
        usuarioService.deletePorID(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/adicionandoDadosID={id}")
    public ResponseEntity<Endereco> adicionandoDados(@PathVariable Long id, @RequestBody Endereco d){
        Usuario u = usuarioService.encontrePorID(id);
        dadosPessoaisService.salvarDados(u,d);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/dadosInfoID={id}")
    public ResponseEntity<Endereco> dadosInfo(@PathVariable Long id){
       Endereco u = dadosPessoaisService.encontrePorID(id);
       return  ResponseEntity.status(HttpStatus.OK).body(u);
    }

    @DeleteMapping("/deleteInfoPorID={id}")
    public ResponseEntity<Endereco> deleteInPorID(@PathVariable Long id){
        dadosPessoaisService.deleteInfoPorID(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/fazerLogin")
    public ResponseEntity<Boolean> ValidarSenha(@RequestParam Long cpf, @RequestParam String senha) {
        Usuario u = usuarioService.encontrePorID(cpf);

        if (u != null && contaService.compararSenha(senha, u.getPassword())) {
            return ResponseEntity.status(HttpStatus.OK).body(true);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }
    }

    @PostMapping("/createConta={id}")
    public ResponseEntity<Conta> createConta(@RequestBody Conta c, @PathVariable Long id){
    Endereco u = dadosPessoaisService.encontrePorID(id);
    contaService.salvarComId(c, id);
   return ResponseEntity.status(HttpStatus.CREATED).body(c);
    }

    @GetMapping("/buscarContaPor={id}")
    public ResponseEntity<Conta> buscarContaPorID(@PathVariable Long id){
        Conta u = contaService.encontrePorID(id);
        return ResponseEntity.ok().body(u);
    }

    @PostMapping("/transferencia")
    public ResponseEntity<Boolean> transferir(@RequestParam Long contaOrigem, @RequestParam Long contaDestino, @RequestParam Double valor ){
        Conta origem = contaService.encontrePorID(contaOrigem);
        Conta destino = contaService.encontrePorID(contaDestino);

        contaService.transferencia(origem, destino, valor);

        return ResponseEntity.status(HttpStatus.OK).build();
    }












}
