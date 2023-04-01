/*
4) Dado o valor de faturamento mensal de uma distribuidora, detalhado por estado:

SP – R$67.836,43
RJ – R$36.678,66
MG – R$29.229,88
ES – R$27.165,48
Outros – R$19.849,53

Escreva um programa na linguagem que desejar onde calcule o percentual de representação
que cada estado teve dentro do valor total mensal da distribuidora.
 */
package Testes;

import java.util.HashMap;//importando a classe HashMap para armazenar o faturamento mensal do estado
import java.util.Map;

public class Teste4 {

    public static void main(String[] args) {
        Map<String, Double> faturamentoPorEstado = new HashMap<>();
        faturamentoPorEstado.put("SP", 67836.43);
        faturamentoPorEstado.put("RJ", 36678.66);
        faturamentoPorEstado.put("MG", 29229.88);
        faturamentoPorEstado.put("ES", 27165.48);
        faturamentoPorEstado.put("Outros", 19849.53);

//Para calcular o faturamento total, utlizei o método values() para obter uma Collection 
//com todos os valores do HashMap, e em seguida foi utilizada o método mapToDouble() para converter
//cada valor em um double e somá-los com o método sum().
        double faturamentoTotal = faturamentoPorEstado.values().stream().mapToDouble(Double::doubleValue).sum();

//Por fim, iteramos sobre o HashMap utilizando um for-each loop e foi calculado o percentual de
//representação de cada estado em relação ao faturamento total utilizando a fórmula 
//(faturamento / faturamentoTotal) * 100. 
        System.out.println("Percentual de representação do faturamento mensal por estado:");
        faturamentoPorEstado.entrySet().forEach(entry -> {
            String estado = entry.getKey();
            Double faturamento = entry.getValue();
            double percentual = (faturamento / faturamentoTotal) * 100;
            System.out.printf("%s: %.2f%%\n", estado, percentual);
        });
    }
}
