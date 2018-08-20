import static java.lang.Math.abs;

public class Fracao {

    /** O numerador da fração. Sempre positivo. */
    private final int numerador;

    /** O denominador da fração. Sempre positivo. */
    private final int denominador;

    /** Indica o sinal da fração. Se true, a fração é positiva. */
    private final boolean positiva;

    /** A (única) fração irredutível que é equivalente a esta fração. */
    private Fracao fracaoIrredutivel;

    private static String separador = "/";

    /**
     * Retorna se a fração é uma fração própria.
     *
     * @return true, se própria; false, caso contrário.
     */
    public boolean ehPropria() {
        return numerador < denominador;
    }

    /**
     * Construtor da classe Fracao.
     *
     * @param n O numerador.
     * @param d O denominador. Não pode ser zero.
     *
     */
    public Fracao(int n, int d) {
        if (d == 0) {
            throw new IllegalArgumentException(
                    "Denominador inválido");
        }

        numerador = abs(n);
        denominador = abs(d);
        positiva = n >= 0 && d > 0 || n < 0 && d < 0;
    }

    public Fracao getFracaoIrredutivel() {
        if (this.fracaoIrredutivel == null) {
            // lazy instantiation
            int mdc = calcularMaximoDivisorComum(this.numerador, this.denominador);
            this.fracaoIrredutivel = new Fracao(
                    (this.numerador / mdc) * (this.positiva ? 1 : -1),
                    this.denominador / mdc);

        }
        return this.fracaoIrredutivel;
    }

    public int getNumerador() {
        return this.numerador;
    }

    public int getDenominador() {
        return this.denominador;
    }

    public boolean isPositiva() {
        return this.positiva;
    }

    /**
     * Encontra o MDC de dois números naturais.
     * @param a Um inteiro positivo.
     * @param b Outro inteiro positivo.
     * @return O MDC. Retorna resultado impresível se algum dos parâmetros for < 1.
     */
    public static int calcularMaximoDivisorComum(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return calcularMaximoDivisorComum(b, a % b);
    }

    public static String getSeparador() {
        return separador;
    }

    @Override
    public String toString() {
        String sinal = positiva ? "" : "-";
        return String.format("%s%d%s%d",
                sinal, numerador,
                separador, denominador);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Fracao))    {
            return false;
        }
        Fracao outra = (Fracao) obj;

        Fracao minhaFracaoIrredutivel = this.getFracaoIrredutivel();
        Fracao outraFracaoIrredutivel = outra.getFracaoIrredutivel();

        return minhaFracaoIrredutivel.numerador == outraFracaoIrredutivel.numerador &&
                minhaFracaoIrredutivel.denominador == outraFracaoIrredutivel.denominador &&
                this.positiva == outra.positiva;
    }
}
