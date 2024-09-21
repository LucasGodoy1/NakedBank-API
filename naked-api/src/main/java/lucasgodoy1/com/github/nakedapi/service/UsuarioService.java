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
    public Usuario encontrePorID(String id){
        Usuario u = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
        return u;
    }

    @Transactional
    public  void alterarSenha(String id, String senha){
        Usuario usuario = encontrePorID(id);
        usuario.setPassword(senha);
    }

    @Transactional
    public List<Usuario> listaDeCadastros(){
        return repository.findAll();
    }


    @Transactional
    public void deletePorID(String id){
        repository.deleteById(id);
    }






}
