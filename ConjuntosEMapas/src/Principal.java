import java.util.*;

public class Principal {

    public static Integer encontrarElementoMaisFrequenteNaive(
            List<Integer> lista) {

        int maxCount = 0;
        Integer maxCountElement = null;

        for (int i = 0; i < lista.size(); i++) {
            int elemento = lista.get(i);
            int count = 0;
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j) == elemento) {
                    count++;
                    if (count > maxCount) {
                        maxCount = count;
                        maxCountElement = elemento;
                    }
                }
            }
        }

        return maxCountElement;
    }

    public static <T> T encontrarElementoMaisFrequente(
            List<T> lista) {

        int maxCount = 0;
        T maxCountElement = null;

        Map<T, Integer> ocorrenciaByElemento =
                new HashMap<>();

        for (T elemento : lista) {
            Integer contador = ocorrenciaByElemento.get(elemento);
            if (contador == null) {
                contador = 1;
            } else {
                contador++;
            }

            ocorrenciaByElemento.put(elemento, contador);
            if (contador > maxCount) {
                maxCount = contador;
                maxCountElement = elemento;
            }
        }

        return maxCountElement;
    }




    public static void encontrarParQueSomaKNaive(List<Integer> numeros,
                                                 int somaDesejada) {
        for (int i = 0; i < numeros.size(); i++) {
            int x = numeros.get(i);
            for (int j = i+1; j < numeros.size(); j++) {
                int y = numeros.get(j);
                if (y + x == somaDesejada) {
                    System.out.printf("Encontrei! Os elementos %d e %d somam %d.\n",
                            x, y, somaDesejada);
                    return;
                }
            }
        }
        System.out.println("Não encontrei.");
    }

    public static void encontrarParQueSomaKUsandoSet(List<Integer> numeros,
                                                     int somaDesejada) {
        Set<Integer> conjunto = new PositiveIntegerSetOverBoleanArray(6_000_000);
//        Set<Integer> conjunto = new HashSet<>();

        for (int i = 0; i < numeros.size(); i++) {
            int x = numeros.get(i);
            int complemento = somaDesejada - x;
            if (conjunto.contains(complemento)) {
                System.out.printf("Encontrei! Os elementos %d e %d somam %d.\n",
                        x, complemento, somaDesejada);
                return;
            }
            conjunto.add(x);
        }
        System.out.println("Não encontrei.");
    }

    public static void main(String[] args) {
        Random random = new Random(1234);
        List<Integer> lista = new ArrayList<>();

        int tamanhoDesejado = 100_000;
        int maxIntSorteado = 1_000_000;

        for (int i = 0; i < tamanhoDesejado; i++) {
            lista.add(random.nextInt(maxIntSorteado));
        }

        long inicio, duracao;

//        inicio = System.currentTimeMillis();
//        encontrarParQueSomaKNaive(lista, 1000);
//        duracao = System.currentTimeMillis() - inicio;
//        System.out.printf("Duracao (naive) = %d milissegundos\n", duracao);

//        inicio = System.currentTimeMillis();
//        encontrarParQueSomaKUsandoSet(lista, 1000);
//        duracao = System.currentTimeMillis() - inicio;
//        System.out.printf("Duracao (com hash set) = %d milissegundos\n", duracao);

        inicio = System.currentTimeMillis();
        Integer resultado = encontrarElementoMaisFrequente(lista);
        duracao = System.currentTimeMillis() - inicio;
        System.out.printf("Mais frequente --> %d\n",
                resultado);
        System.out.printf("Duracao = %d milissegundos\n", duracao);

    }
}
