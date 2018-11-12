package modelo;

public class LojaViaBoleto<T extends Transportador>
        extends Loja<Livro, T> {

    protected LojaViaBoleto(T transportador) {
        super(transportador);
    }

    @Override
    protected void receberPagamento(Pessoa comprador, float preco) {
        emitirBoleto(preco);
    }

    public T getMeuTransportador() {
        return transportador;
    }

    private void emitirBoleto(float preco) {
        System.out.printf("Emitindo boleto no valor de %.2f reais...\n", preco);
    }
}
