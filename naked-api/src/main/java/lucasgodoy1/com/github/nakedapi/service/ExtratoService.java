package lucasgodoy1.com.github.nakedapi.service;

import lombok.RequiredArgsConstructor;
import lucasgodoy1.com.github.nakedapi.entity.Extrato;
import lucasgodoy1.com.github.nakedapi.repository.TransacaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExtratoService {
    private final TransacaoRepository transacaoRepository;

    @Transactional
    public void salvar(Extrato extrato){
        transacaoRepository.save(extrato);
    }

}
