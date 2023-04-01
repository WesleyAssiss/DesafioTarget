package Testes;

public class Teste1 {

    public static void main(String[] args) {

        int indice = 13, SOMA = 0, K = 0;
//O código entra em um loop enquanto K for menor que INDICE. 
//Dentro do loop, a variável K é incrementada em 1 (K = K + 1) e SOMA é atualizada 
//com o valor atual de SOMA somado a K (SOMA = SOMA + K). 
//Ou seja, a cada iteração do loop, SOMA é atualizado com o próximo número inteiro
//sequencial a partir de 1, até chegar a 13.
        while (K < indice) {
            K += 1;
            SOMA += K;
        }
//Quando K se torna igual a INDICE (13), o loop para de executar e o valor final
//de SOMA é impresso na tela através da função "imprimir".

        System.out.println(SOMA);
    }
}
//saída 91.
