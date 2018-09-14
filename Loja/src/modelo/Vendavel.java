package modelo;

/**
 * Modela itens que podem ser vendidos.
 */
public interface Vendavel {

    /**
     * @return a descrição do item.
     */
    String getDescricao();

    /**
     * @return o preço em reais.
     */
    float getPreco();
}
