//package lucasgodoy1.com.github.nakedapi.service;
//
//import lombok.RequiredArgsConstructor;
//import lucasgodoy1.com.github.nakedapi.entity.Conta;
//import lucasgodoy1.com.github.nakedapi.entity.Cliente;
//import lucasgodoy1.com.github.nakedapi.entity.Extrato;
//import lucasgodoy1.com.github.nakedapi.repository.ContaRepository;
//import lucasgodoy1.com.github.nakedapi.repository.DadosPessoaisRepository;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Random;
//
//@RequiredArgsConstructor
//@Service
//public class ContaService {
//    private final ContaRepository contaRepository;
//    private final DadosPessoaisRepository dadosPessoaisRepository;
//    private static final Random random = new Random();
//
//    public static String encoder(String senha) {
//        BCryptPasswordEncoder encoderSenha = new BCryptPasswordEncoder();
//        return encoderSenha.encode(senha);
//    }
//
//    @Transactional
//    public Boolean compararSenha(String requestSenha, String senhaRegistrada) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        return passwordEncoder.matches(requestSenha, senhaRegistrada);
//    }
//
//    public static String geraNumeroConta(int origin, int bound, int length) {
//        if (bound <= origin) {
//            throw new IllegalArgumentException("bound must be greater than origin");
//        }
//        StringBuilder numeroConta = new StringBuilder();
//        for (int i = 0; i < length; i++) {
//            int digit = random.nextInt(bound - origin) + origin;
//            numeroConta.append(digit);
//        }
//        return numeroConta.toString();
//    }
//
//    @Transactional
//    public Conta salvarComId(Conta conta, Long id) {
//        Cliente dados = dadosPessoaisRepository.findById(id).orElseThrow(() -> new RuntimeException("Dados pessoais não encontrados"));
//        conta.setNomeCompleto(dados.getNomeCompleto());
//        contaRepository.save(conta);
//        return conta;
//    }
//
//    @Transactional(readOnly = true)
//    public Conta encontrePorID(Long id) {
//        Conta conta = contaRepository.findById(id).orElseThrow(() -> new RuntimeException("Conta não encontrada"));
//        initializeExtratoList(conta);
//        return conta;
//    }
//
//    private void initializeExtratoList(Conta conta) {
//        List<Extrato> extratoList = conta.getExtratoList();
//        extratoList.size(); // Força a inicialização
//    }
//    @Transactional
//    public void adicionarSaldo(Conta c, Double valor) {
//        c.setSaldo(c.getSaldo() + valor);
//    }
//
//    @Transactional
//    public boolean transferencia(Conta contaOrigem, Conta contaDestino, Double valor) {
//        if (contaOrigem.getSaldo() >= valor) {
//            contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
//            this.adicionarSaldo(contaDestino, valor);
//
//            Extrato transacaoOrigem = new Extrato("Transferencia", valor);
//            Extrato transacaoDestino = new Extrato("Transferencia Recebida", valor);
//
//            transacaoOrigem.setConta(contaOrigem);
//            transacaoDestino.setConta(contaDestino);
//
//            contaOrigem.getExtratoList().add(transacaoOrigem);
//            contaDestino.getExtratoList().add(transacaoDestino);
//
//            contaRepository.save(contaOrigem);
//            contaRepository.save(contaDestino);
//
//            return true;
//        } else {
//            return false;
//        }
//    }
//}
