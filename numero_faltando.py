from time import time
from random import shuffle

def criarEntrada(tamanho):
    lista = [i for i in range(tamanho)]
    shuffle(lista)
    return lista

def encontrarNumeroQuadratico(numeros):
    n = len(numeros)
    for candidato in range(n+1):
        encontrei = False
        for pos in range(n):
            if numeros[pos] == candidato:
                encontrei = True
                break
        if not encontrei:
            return candidato

def encontrarNumeroOrdenando(numeros):
    n = len(numeros) 
    numeros.sort()
    candidato = 0
    for pos in range(n):
        numero = numeros[pos]
        if numero > candidato:
            return candidato
        elif numero == candidato:
            candidato += 1
    return candidato

def encontrarNumeroLinear(numeros):
    n = len(numeros)
    encontrados = [False] * (n+1)
    for numero in numeros:
        encontrados[numero] = True
    for numero, encontrei in enumerate(encontrados):
        if not encontrei:
            return numero


while True:
    N = int(input("Digite n: "))

    print("Criando lista...")
    numeros = criarEntrada(N)

    print("Rodando algoritmo...")
    inicio = time()
    resultado = encontrarNumeroLinear(numeros)
    duracao = time() - inicio
    print("O numero ausente eh %d (duracao: %.3f segundos)" % (resultado, duracao))




