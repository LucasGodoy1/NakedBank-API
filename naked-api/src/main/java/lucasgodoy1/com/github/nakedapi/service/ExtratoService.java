package lucasgodoy1.com.github.nakedapi.service;

import lombok.RequiredArgsConstructor;
import lucasgodoy1.com.github.nakedapi.entity.Extrato;
import lucasgodoy1.com.github.nakedapi.repository.ExtratoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ExtratoService {
    private final ExtratoRepository extratoRepository;

    @Transactional
    public void salvar(Extrato extrato){
        extratoRepository.save(extrato);
    }

    @Transactional
    public List<Extrato> meusExtratos(String contaID) {
        return extratoRepository.findByContaID_NumeroDaConta(contaID);
    }


}
