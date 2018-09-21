package modelo;

public abstract class Loja {

    private static final int MAX_ITEMS_ESTOQUE = 1000;

    private Transportador transportador;

    private Vendavel[] vitrine;

    private int contItemsNaVitrine;

    protected Loja(Transportador transportador) {
        this.transportador = transportador;
        this.vitrine = new Vendavel[MAX_ITEMS_ESTOQUE];
        this.contItemsNaVitrine = 0;
    }

    public void adicionarItemAVitrine(Vendavel item) {
        this.vitrine[this.contItemsNaVitrine++] = item;
    }

    public void efetuarVenda(Vendavel item,
                             String enderecoDeEntrega,
                             Pessoa comprador) {

        receberPagamento(comprador, item.getPreco());
        emitirRecibo(item.getDescricao(), item.getPreco());
        transportador.entregar(item, enderecoDeEntrega);
    }

    protected abstract void receberPagamento(Pessoa comprador, float preco);

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

    public Vendavel getItemVitrine(int posicao) {
        return this.vitrine[posicao];
    }
}
