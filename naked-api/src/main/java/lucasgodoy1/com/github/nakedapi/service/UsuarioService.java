package lucasgodoy1.com.github.nakedapi.service;

import lombok.RequiredArgsConstructor;
import lucasgodoy1.com.github.nakedapi.entity.Usuario;
import lucasgodoy1.com.github.nakedapi.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    @Transactional
    public void salvar(Usuario u){
        repository.save(u);
    }
    @Transactional
    public void salvarVarios(List<Usuario> u){
        repository.saveAll(u);
    }

    @Transactional
    public Usuario encontrePorID(Long id){
        Usuario u = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
        return u;
    }

    @Transactional
    public  void alterarSenha(Long id, String senha){
        Usuario usuario = encontrePorID(id);
        usuario.setPassword(senha);
    }

    @Transactional
    public List<Usuario> listaDeCadastros(){
        //List<Usuario> lista = repository.findAll();
        //para diminuir futuros problemas de performance a chamada será direta sem variavel
        return repository.findAll();
    }


    @Transactional
    public void deletePorID(Long id){
        repository.deleteById(id);
    }






}
