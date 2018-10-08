import java.util.*;

public class Principal {

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
        Random random = new Random();
        List<Integer> lista = new ArrayList<>();

        int tamanhoDesejado = 640_000;
        int maxIntSorteado = 6_000_000;

        for (int i = 0; i < tamanhoDesejado; i++) {
            lista.add(random.nextInt(maxIntSorteado));
        }

        long inicio, duracao;

//        inicio = System.currentTimeMillis();
//        encontrarParQueSomaKNaive(lista, 1000);
//        duracao = System.currentTimeMillis() - inicio;
//        System.out.printf("Duracao (naive) = %d milissegundos\n", duracao);

        inicio = System.currentTimeMillis();
        encontrarParQueSomaKUsandoSet(lista, 1000);
        duracao = System.currentTimeMillis() - inicio;
        System.out.printf("Duracao (com hash set) = %d milissegundos\n", duracao);

    }
}
