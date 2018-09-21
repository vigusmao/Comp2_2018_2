package modelo;

public class LojaViaBoleto extends Loja {

    protected LojaViaBoleto(Transportador transportador) {
        super(transportador);
    }

    @Override
    protected void receberPagamento(Pessoa comprador, float preco) {
        emitirBoleto(preco);
    }

    private void emitirBoleto(float preco) {
        System.out.printf("Emitindo boleto no valor de %.2f reais...\n", preco);
    }
}
