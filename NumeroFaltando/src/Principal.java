import java.util.Arrays;
import java.util.Random;

public class Principal {

    /**
     * Retorna o único inteiro, do range [0..n], que não
     * se encontra no array passado como parâmetro, onde
     * n é o tamanho do array.
     *
     * @param numeros um array de inteiros distintos
     * @return o inteiro ausente;
     * ou -1 caso haja mais de um inteiro ausente
     * ou a lista esteja vazia
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

    static int encontrarNumeroAusenteOrdenando(int[] numeros) {
        int n = numeros.length;
        if (n == 0) {
            return -1;  // lista vazia
        }

        Arrays.sort(numeros);

        int numeroAusente = -1;

        int pos = 0;
        for (int candidatoDaVez = 0; candidatoDaVez <= n; candidatoDaVez++) {

            int numeroEncontrado = pos < n ? numeros[pos] : n + 1;
            if (numeroEncontrado == candidatoDaVez) {
                pos++;
            } else if (numeroEncontrado > candidatoDaVez) {
                // encontrei um numero ausente!!!
                if (numeroAusente != -1) {
                    return -1;  // mais de um ausente!!!
                } else {
                    numeroAusente = candidatoDaVez;
                }
            } else {  // if (numeroEncontrado < candidatoDaVez) {
                return -1;  // certamente haverá mais de um ausente!

            }
        }
        return numeroAusente;
    }

    static int encontrarNumeroAusenteLinear(int[] numeros) {
        int n = numeros.length;
        if (n == 0) {
            return -1;  // lista vazia
        }

        boolean[] marcadores = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            marcadores[i] = false;
        }

//        for (int i = 0; i < n; i++) {
//            int numeroEncontrado = numeros[i];
//            marcadores[numeroEncontrado] = true;
//        }
//        Da maneira abaixo é um pouco mais elegante.
        
        for (int numeroEncontrado : numeros) {
            marcadores[numeroEncontrado] = true;
        }

        int numeroAusente = -1;

        for (int candidatoDaVez = 0; candidatoDaVez <= n; candidatoDaVez++) {
            if (!marcadores[candidatoDaVez]) {
                // encontrei um numero ausente!!!
                if (numeroAusente != -1) {
                    return -1;  // mais de um ausente!!!
                } else {
                    numeroAusente = candidatoDaVez;
                }
            }
        }

        return numeroAusente;
    }

    private static int[] createArray(int n) {
        int[] numeros = new int[n];
        int x = 0;
        for (int pos = 0; pos < n; pos += 2) {
            numeros[pos] = x++;
        }
        for (int pos = 1; pos < n; pos += 2) {
            numeros[pos] = x++;
        }

        Random random = new Random();
        int y = random.nextInt(n + 1);
        if (y < n) {
            numeros[y] = n;
        }
        return numeros;
    }

    private static void imprimirArray(int[] array) {
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }
//        A linha abaixo faz a mesma coisa, melhor.

        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        for (int n = 1_000; n < 1_000_000; n *= 2) {
            System.out.println("\n---------------\nn = " + n);

            int[] numeros = createArray(n);
//            imprimirArray(numeros);

            long inicio, duracao;
            int resultado;

            inicio = System.currentTimeMillis();
            resultado = encontrarNumeroAusente(numeros);
            duracao = System.currentTimeMillis() - inicio;
            System.out.printf("O número ausente é %d (duração: %d milis) -- O(n^2)\n",
                    resultado, duracao);

            inicio = System.currentTimeMillis();
            resultado = encontrarNumeroAusenteOrdenando(numeros);
            duracao = System.currentTimeMillis() - inicio;
            System.out.printf("O número ausente é %d (duração: %d milis) -- O(n log n)\n",
                    resultado, duracao);

            inicio = System.currentTimeMillis();
            resultado = encontrarNumeroAusenteLinear(numeros);
            duracao = System.currentTimeMillis() - inicio;
            System.out.printf("O número ausente é %d (duração: %d milis) -- O(n)\n",
                    resultado, duracao);
        }
    }
}

