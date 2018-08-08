public class Principal {

    /**
     * Retorna o único inteiro, do range [0..n], que não
     * se encontra no array passado como parâmetro, onde
     * n é o tamanho do array.
     *
     * @param numeros um array de inteiros distintos
     * @return o inteiro ausente;
     *         ou -1 caso haja mais de um inteiro ausente
     *         ou a lista esteja vazia
     *
     */
    static int encontrarNumeroAusente(int[] numeros) {
        int n = numeros.length;
        if (n == 0) {
            return -1;
        }

        int numeroAusente = -1;  // não encontrei ainda nenhum ausente

        for (int candidato = 0; candidato <= n; candidato++) {
            boolean localizeiNoArray = false;
            for (int pos = 0; pos < n; pos++) {
                if (numeros[pos] == candidato) {
                    localizeiNoArray = true;
                    break;
                }
            }
            if (!localizeiNoArray) {
                if (numeroAusente == -1) {
                    numeroAusente = candidato;
                } else {
                    return -1;  // mais de um ausente encontrado!!
                }
            }
        }

        return numeroAusente;
    }
}
