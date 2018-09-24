package dominio;

public interface MeioDePagamento {

    default void pagar(float valor) {
        pagar(valor, "Real");
    }

    void pagar(float valor, String moeda);

    default void receber(float valor) {
        // nao faca nada;
    }
}
