import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EncontradorDeMaisFrequente<T> {

    public T encontrarElementoMaisFrequente(
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

}



