public class Banco {

    public void depositar(long numeroDaConta, int valor)
            throws ValorInvalidoException, ContaInexistenteException {


        if (valor < 0) {
            throw new ValorInvalidoException("Valor inválido: " + valor);
        }

        if (!existeConta(numeroDaConta)) {
            throw new ContaInexistenteException("Conta inválida: " + numeroDaConta);
        }

        // deposita o valor na conta :-))
    }

    private boolean existeConta(long numeroDaConta) {
        return numeroDaConta > 0 & numeroDaConta < 10000;
    }


}
