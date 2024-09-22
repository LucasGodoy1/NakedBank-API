package lucasgodoy1.com.github.nakedapi.controller;

import lombok.RequiredArgsConstructor;
import lucasgodoy1.com.github.nakedapi.entity.Conta;
import lucasgodoy1.com.github.nakedapi.entity.Extrato;
import lucasgodoy1.com.github.nakedapi.service.ContaService;
import lucasgodoy1.com.github.nakedapi.service.ExtratoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/nakedBank/transacao")
public class TransacaoWebController {
    private final ContaService contaService;
    private final ExtratoService extratoService;

    @PostMapping("/transferencia")
    public ResponseEntity<Boolean> transferencia(@RequestParam String numeroConta1, @RequestParam String numeroConta2, @RequestParam Double valor ){
        Conta conta1 = contaService.encontrePorID(numeroConta1);
        Conta conta2 = contaService.encontrePorID(numeroConta2);

        var transferencia = contaService.transferencia(conta1, conta2, valor);


            Extrato extratoContaOrigem = new Extrato("Transferencia Enviada!", valor, conta1);
            Extrato extratoContaDestino = new Extrato("Transferencia Recebida!", valor, conta2);

            extratoService.salvar(extratoContaOrigem);
            extratoService.salvar(extratoContaDestino);

            return ResponseEntity.status(HttpStatus.ACCEPTED).body(transferencia);

    }

    @PostMapping("/deposito")
    public ResponseEntity<Boolean> transferencia(@RequestParam String numeroConta, @RequestParam Double valor ){
        Conta conta = contaService.encontrePorID(numeroConta);
        conta.setSaldo(conta.getSaldo() + valor);

        contaService.salvar(conta);

        Extrato extrato = new Extrato("Deposito Recebido!", valor, conta);
        extratoService.salvar(extrato);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }



}
