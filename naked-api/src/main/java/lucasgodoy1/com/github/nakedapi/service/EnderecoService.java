package lucasgodoy1.com.github.nakedapi.service;


import lombok.RequiredArgsConstructor;
import lucasgodoy1.com.github.nakedapi.entity.Cliente;
import lucasgodoy1.com.github.nakedapi.entity.Endereco;
import lucasgodoy1.com.github.nakedapi.entity.Usuario;
import lucasgodoy1.com.github.nakedapi.repository.EnderecoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@RequiredArgsConstructor
@Service
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;


    @Transactional
    public void salvarDados(Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    @Transactional
    public Endereco encontrePorID(Long id){
        Endereco e = enderecoRepository.findById(id).get();
        return e;
    }

    @Transactional
    public void deleteInfoPorID(Long id){
        enderecoRepository.deleteById(id);
    }




}
