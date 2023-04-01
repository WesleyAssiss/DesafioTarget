/*
3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa, na linguagem que desejar, que calcule e retorne:
• O menor valor de faturamento ocorrido em um dia do mês;
• O maior valor de faturamento ocorrido em um dia do mês;
• Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.

IMPORTANTE:
a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal;
b) Podem existir dias sem faturamento, como nos finais de semana e feriados. Estes dias devem ser ignorados no cálculo da média;
 */
package Testes;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Importando as bibliotecas necessárias: 'java.io.*org.json.simple.* para fazer o parsing do JSON.
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;//Instanciando um objeto 'JSONParserfaturamento para guardar os valores de faturamento.
import org.json.simple.parser.ParseException;

public class Teste3 {

    public static void main(String[] args) throws Exception {
        JSONParser parser = new JSONParser();
        List<Double> faturamento = new ArrayList<>();
        //Criamos as variáveis 'menordiasAcimaMedia e inicializamos 
        //menormenor .commaior com o valor mínimo possível, para garantir que qualquer valor de 
        //faturamento será menor ou maior que eles, respectivamente.
        double menor = Double.MAX_VALUE;
        double maior = Double.MIN_VALUE;
        double soma = 0;
        int diasAcimaMedia = 0;//
//Utilizamos o JSONParser
//A partir do objeto JSONObject
        try {
            Object obj = parser.parse(new FileReader("faturamento.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray dias = (JSONArray) jsonObject.get("dias");//Para cada dia, 
            //foi o objeto JSON em um 'JSONObject

            for (Object dia : dias) {
                JSONObject jsonDia = (JSONObject) dia;
                if (jsonDia.get("faturamento") != null) {
                    double valor = Double.parseDouble(jsonDia.get("faturamento").toString());
                    if (valor < menor) {//Durante a iteração, também foi verificado se o valor de faturamento 
                        //atual é menor que 'menor
                        menor = valor;
                    }
                    if (valor > maior) {
                        maior = valor;
                    }
                    soma += valor;
                    faturamento.add(valor);
                }
            }

            double media = soma / faturamento.size();
            for (double valor : faturamento) {
                if (valor > media) {
                    diasAcimaMedia++;
                }
            }

            System.out.println("Menor valor de faturamento: " + menor);
            System.out.println("Maior valor de faturamento: " + maior);
            System.out.println("Número de dias acima da média: " + diasAcimaMedia);
        } catch (IOException | ParseException e) {
        }
    }
}
