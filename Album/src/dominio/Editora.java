package dominio;

import java.util.Random;

/**
 * Implementa a editora responsável pela publicação de um único álbum de figurinhas.
 * Possui métodos para compra de pacotinhos de figurinhas e figurinhas específicas para álbuns suficientemente
 * preenchidos.
 */
public class Editora {

    public final static int PERCENTUAL_MINIMO_PARA_COMPRAS_ESPECIFICAS = 90;

    private final int figurinhasPorPacotinho;
    private final int totalFigurinhasNoAlbum;

    private final Random random;

    public Editora(int figurinhasPorPacotinho, int totalFigurinhasNoAlbum) {
        this.figurinhasPorPacotinho = figurinhasPorPacotinho;
        this.totalFigurinhasNoAlbum = totalFigurinhasNoAlbum;
        this.random = new Random();
    }

    /**
     * Retorna um pacotinho aleatório de figurinhas.
     * @return um array de inteiros representando as figurinhas adquiridas.
     */
    public int[] adquirirPacotinhoAleatorio() {
        int[] pacotinho = new int[this.figurinhasPorPacotinho];
        for (int i = 0; i < this.figurinhasPorPacotinho; i++) {
            int figurinha = random.nextInt(this.totalFigurinhasNoAlbum) + 1;
            pacotinho[i] = figurinha;
        }
        return pacotinho;
    }

    /**
     * Acrescenta uma figurinha específica desejada pelo usuário no álbum fornecido.
     * Obs.: Álbuns com menos de PERCENTUAL_MINIMO_PARA_COMPRAS_ESPECIFICAS
     *       não poderão adquirir figurinhas por este método, e o método nada fará.
     *
     * @param numeroDaFigurinha o número da figurinhas desejada.
     * @param album O álbum parcialmente completo ao qual a figurinha desejada
     *              deverá pertencer.
     */
    public void adquirirFigurinha(int numeroDaFigurinha, Album album) {
        // ToDo IMPLEMENT ME!
    }
}
