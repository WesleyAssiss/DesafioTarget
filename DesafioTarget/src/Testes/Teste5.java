/*
5) Escreva um programa que inverta os caracteres de um string.

IMPORTANTE:
a) Essa string pode ser informada através de qualquer entrada de sua preferência 
ou pode ser previamente definida no código;
b) Evite usar funções prontas, como, por exemplo, reverse;
 */
package Testes;

import java.util.Scanner;//importando a classe Scanner

public class Teste5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite uma palavra: ");//Solicitando ao usuário a digitar uma palavra
        String palavra = sc.nextLine();

        String palavraInvertida = "";//criando a varável para tornar a palavra invertida

        for (int i = palavra.length() - 1; i >= 0; i--) {//utilizando o loop
            palavraInvertida += palavra.charAt(i);
        }

        System.out.println("Palavra invertida: " + palavraInvertida);
    }
}
