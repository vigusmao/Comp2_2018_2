package modelo;

public class Loja {

    private static final int MAX_ITEMS_ESTOQUE = 1000;

    private Transportador transportador;

    private Vendavel[] vitrine;

    private int contItemsNaVitrine;

    public Loja(Transportador transportador) {
        this.transportador = transportador;
        this.vitrine = new Vendavel[MAX_ITEMS_ESTOQUE];
        this.contItemsNaVitrine = 0;
    }

    public void adicionarItemAVitrine(Vendavel item) {
        this.vitrine[this.contItemsNaVitrine++] = item;
    }

    public void efetuarVenda(Vendavel item,
                             String enderecoDeEntrega,
                             long numeroDoCartaoDeCredito) {
        descontarValorDoCartao(numeroDoCartaoDeCredito, item.getPreco());
        emitirRecibo(item.getDescricao(), item.getPreco());
        transportador.entregar(item, enderecoDeEntrega);
    }

    public String getVitrineAsString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < this.contItemsNaVitrine; i++) {
            Vendavel item = this.vitrine[i];
            sb.append(item.getDescricao())
              .append(" -- preço: R$")
              .append(item.getPreco())
              .append("\n");
        }
        return sb.toString();
    }

    public Vendavel[] getVitrine() {
        return this.vitrine;
    }

    private void emitirRecibo(String descricao, float preco) {
        System.out.printf("Emitindo recibo sobre %s no valor " +
                "de %.2f reais...\n", descricao, preco);
    }

    private void descontarValorDoCartao(
            long numeroDoCartao, float preco) {
        System.out.printf("Descontando %.2f reais do cartão %d...\n",
                preco, numeroDoCartao);
    }

    public Vendavel getItemVitrine(int posicao) {
        return this.vitrine[posicao];
    }
}
