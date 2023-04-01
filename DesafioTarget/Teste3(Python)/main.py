#3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa,
# na linguagem que desejar, que calcule e retorne:
# • O menor valor de faturamento ocorrido em um dia do mês;
# • O maior valor de faturamento ocorrido em um dia do mês;
# • Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.
# IMPORTANTE:
# a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal;
# b) Podem existir dias sem faturamento, como nos finais de semana e feriados.
# Estes dias devem ser ignorados no cálculo da média;


import json


# Imprimindo as informações de faturamento
def read_json(path):
    with open(path) as file:
        data = json.load(file)
        d, m = max_value(data)
        d1, m1 = min_value(data)
        a = average(data)
        count = above_average(data, a)
        print(f'O menor valor R$ {m1} ocorreu no dia: {d1}')
        print(f'O maior valor R$ {m} ocorreu no dia: {d}')
        print(f'O número de dias com faturamento acima da média é {count}')
        print(f'A média do faturamento mensal é {a}')


# Calculando o maior valor de faturamento diário do mês
def max_value(data):
    m = 0
    d = 0
    for value in data:
        if m < float(value['valor']):
            m = float(value['valor'])
            d = value['dia']
    # Retornando as informações calculadas
    return d, m


# Calculando o menor valor de faturamento diário do mês
def min_value(data):
    m = 9999999999999999999
    d = 0
    for value in data:
        if m > float(value['valor']):
            m = float(value['valor'])
            d = value['dia']
    # Retornando as informações calculadas
    return d, m


# Calculando a média mensal de faturamento diário (ignorando dias sem faturamento)
def average(data):
    t = 0
    s = 0
    for value in data:
        if float(value['valor']):
            s += float(value['valor'])
            t += 1
    # Retornando as informações calculadas
    return s / t


# Contando o número de dias com faturamento acima da média mensal
def above_average(data, average):
    count = 0
    for value in data:
        if float(value['valor']) > average:
            count += 1
    return count


# Lendo o arquivo JSON com o faturamento mensal
read_json(r'xml/faturamento_mensal.json')
