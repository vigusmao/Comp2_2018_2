public class ArquivoCorrompidoException extends Exception {

    private int quantLinhasInvalidas;

    public ArquivoCorrompidoException(int quantLinhasInvalidas) {
        this.quantLinhasInvalidas = quantLinhasInvalidas;
    }

    public int getQuantLinhasInvalidas() {
        return quantLinhasInvalidas;
    }
}
