package lucasgodoy1.com.github.nakedapi.service;

import java.util.Random;

public class NumerosAleatorios {
    private static final Random random = new Random();



    public static String geraNumeroConta(int menorValor, int maiorValor, int quantidadeDeDigitos) {
        StringBuilder numeroConta = new StringBuilder();
        for (int i = 0; i < quantidadeDeDigitos; i++) {
            int digito = random.nextInt(maiorValor - menorValor) + menorValor;
            numeroConta.append(digito);
        }
        numeroConta.append("-");
        numeroConta.append(random.nextInt(9) + 1);
        return numeroConta.toString();
    }

}
