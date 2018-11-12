package modelo;

import java.util.Random;

public class FabricaDeLojas {

    private static final int MAX_LOJAS = 10;

    private static Loja[] poolDeLoja = new Loja[MAX_LOJAS];

    private static int contLojasCriadas = 0;

    private static Random random = new Random();

    /** Retorna uma loja qualquer que usurá o transportador informado
     * para fazer suas entregas.
     *
     * @param transportador O transportador da loja que será retornada
     * @return Uma Loja
     */
    public static Loja<Livro, Pessoa> obterLoja(Transportador transportador) {
        Loja loja;
        if (contLojasCriadas < MAX_LOJAS) {
            loja = new LojaViaBoleto(transportador);
            poolDeLoja[contLojasCriadas] = loja;
            contLojasCriadas++;
        } else {
            loja = poolDeLoja[random.nextInt(MAX_LOJAS)];
        }
        return loja;
    }
}
