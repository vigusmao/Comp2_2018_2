public class ContaInexistenteException extends Exception {

    private static int contOcorrencias = 0;

    public ContaInexistenteException(String msg) {
        super(String.format("%s (ocorrências dessa exceção: %d)",
                msg, ++contOcorrencias));
    }

    public int getContOcorrencias() {
        return contOcorrencias;
    }
}
