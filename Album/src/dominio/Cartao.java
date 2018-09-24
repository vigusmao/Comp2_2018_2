package dominio;

public class Cartao implements MeioDePagamento {

    private long numeroDoCartao;

    public Cartao(long numeroDoCartao) {
        this.numeroDoCartao = numeroDoCartao;
    }

    @Override
    public void pagar(float valor, String moeda) {
        System.out.printf("Estou lançando um débito de %s %.2f " +
                "na fatura...\n", moeda, valor);
    }
}
