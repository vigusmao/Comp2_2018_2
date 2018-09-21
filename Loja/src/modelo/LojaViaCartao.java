package modelo;

public class LojaViaCartao extends Loja {

    protected LojaViaCartao(Transportador transportador) {
        super(transportador);
    }

    @Override
    protected void receberPagamento(Pessoa comprador, float preco) {
        descontarValorDoCartao(comprador.getNumeroDoCartaoDeCredito(), preco);
    }

    private void descontarValorDoCartao(
            long numeroDoCartao, float preco) {
        System.out.printf("Descontando %.2f reais do cartão %d...\n",
                preco, numeroDoCartao);
    }
}
