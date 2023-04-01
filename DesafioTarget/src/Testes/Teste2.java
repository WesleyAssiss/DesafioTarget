package Testes;

import java.util.ArrayList;
import java.util.Scanner;

public class Teste2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Informe um número: ");
        int n = input.nextInt();

        ArrayList<Integer> fib = new ArrayList<>();//Criando uma lista e adicionando os dois primeiros números da sequência de Fibonacci: 0 e 1.fib
        fib.add(0);
        fib.add(1);
///Iniciando um loop que continuará adicionando números à lista até que o último número adicionado 
//seja maior ou igual ao número informado pelo usuário.whilefib
//Dentro do loop, foi adicionado o próximo número da sequência de Fibonacci à lista através da
//soma dos dois últimos números.fib
        while (fib.get(fib.size() - 1) < n) {
            fib.add(fib.get(fib.size() - 1) + fib.get(fib.size() - 2));
        }
//Verifica se o número informado pelo usuário pertence à lista utilizando o método da classe .fibcontainsArrayList
//e o número pertencer à lista, imprime uma mensagem informando que ele pertence à sequência de Fibonacci. Caso contrário, imprime 
//uma mensagem informando que ele não pertence.
        if (fib.contains(n)) {
            System.out.println("O número " + n + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + n + " não pertence à sequência de Fibonacci.");
        }

    }

}

