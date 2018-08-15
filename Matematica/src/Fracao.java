import static java.lang.Math.abs;

public class Fracao {

    /** O numerador da fração. Sempre positivo. */
    private final int numerador;

    /** O denominador da fração. Sempre positivo. */
    private final int denominador;

    /** Indica o sinal da fração. Se true, a fração é positiva. */
    private final boolean positiva;

    private static String separador = "/";

    public boolean ehPropria() {
        return numerador < denominador;
    }

    /**
     * Construtor da classe Fracao.
     *
     * @param n O numerador. Precisa ser não-negativo.
     * @param d O denominador. Precisa ser positivo.
     */
    public Fracao(int n, int d) throws IllegalArgumentException {
        if (d == 0) {
            throw new IllegalArgumentException(
                    "Denominador inválido");
        }

        numerador = abs(n);
        denominador = abs(d);
        positiva = n >= 0 && d > 0 || n < 0 && d < 0;
    }

    public String toString() {
        String sinal = positiva ? "" : "-";
        return String.format("%s%d%s%d",
                sinal, numerador,
                separador, denominador);
    }
}
