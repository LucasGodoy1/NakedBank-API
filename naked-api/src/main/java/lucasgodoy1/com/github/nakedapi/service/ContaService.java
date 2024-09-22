package lucasgodoy1.com.github.nakedapi.service;

import lombok.RequiredArgsConstructor;
import lucasgodoy1.com.github.nakedapi.entity.Conta;
import lucasgodoy1.com.github.nakedapi.entity.Extrato;
import lucasgodoy1.com.github.nakedapi.repository.ContaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class ContaService {
    private final ContaRepository contaRepository;


    @Transactional
    public void salvar(Conta conta) {
        contaRepository.save(conta);
    }

    @Transactional(readOnly = true)
    public Conta encontrePorID(String id) {
        Conta conta = contaRepository.findById(id).orElseThrow(() -> new RuntimeException("Conta não encontrada"));
        return conta;
    }


    @Transactional
    public void adicionarSaldo(Conta c, Double valor) {
        c.setSaldo(c.getSaldo() + valor);
    }

    @Transactional
    public boolean transferencia(Conta contaOrigem, Conta contaDestino, Double valor) {
        if (contaOrigem.getSaldo() >= valor) {
            contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
            this.adicionarSaldo(contaDestino, valor);

            Extrato transacaoOrigem = new Extrato("Transferencia", valor, contaOrigem);
            transacaoOrigem.setContaID(contaOrigem);

            Extrato transacaoDestino = new Extrato("Transferencia Recebida", valor, contaDestino);
            transacaoDestino.setContaID(contaDestino);

            salvar(contaOrigem);
            salvar(contaDestino);

            return true;

        }
        return false;

    }

}
