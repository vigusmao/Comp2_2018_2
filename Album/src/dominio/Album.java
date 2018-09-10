package dominio;

public class Album {

    /**
     * Um array de Figurinhas, onde na posição k teremos a figurinha
     * cujo atributo `posicao` é k; ou null, caso não tenhamos a figura
     * em questão.
     */
    private Figurinha[] figurinhas;

    private int contFigurinhas;

    /** Um array de inteiros, onde a posição k indicará a quantidade de repetidas da
     * figurinha k.
     */
    private int[] repetidas;

    private int contRepetidas;

    /** O total de figurinhas do álbum completo.
     */
    private final int tamanho;

    /**
     * @param tamanho O número total de figurinhas do álbum.
     */
    public Album(int tamanho) {
        super();
        this.tamanho = tamanho;
        this.figurinhas = new Figurinha[tamanho + 1];  // descartaremos a posição 0
        this.repetidas = new int[tamanho + 1];  // idem
        this.contFigurinhas = 0;
    }

    /**
     * Retorna se determinada figurinha existe no álbum.
     * @param numeroDaFigurinha a figurinha desejada
     * @return true, se a figurinha existir no álbum; false, caso contrário
     */
    public boolean possuiFigurinha(int numeroDaFigurinha) {
        return this.figurinhas[numeroDaFigurinha] != null;
    }

    /**
     * Processa uma figurinha recém-adquirida, acrescento-a ao álbum, caso
     * seja inédita, ou ao monte de figurinhas repetidas, caso não seja.
     *
     * @param figurinha A figurinha a ser recebida.
     */
    public void receberFigurinha(Figurinha figurinha) {
        int posicao = figurinha.getPosicao();
        if (this.figurinhas[posicao] != null) {
            // figurinha repetida!
            this.repetidas[posicao]++;
            this.contRepetidas++;

        } else {
            // figurinha inédita!
            this.figurinhas[posicao] = figurinha;
            this.contFigurinhas++;
        }
    }

    /**
     * Indica se o álbum está cheio.
     *
     * @return true, caso esteja cheio; false, caso contrário.
     */
    public boolean isCheio() {
        return this.contFigurinhas == this.tamanho;
    }

    /**
     * Recebe uma figurinha, e fornece outra em troca.
     * A figurinha que sai precisa ser uma figurinha repetida; do contrário,
     * o método não fará nada.
     * @param figurinhaQueEntra a nova figurinha (não precisa ser inédita)
     * @param figurinhaQueSai a figurinha que é dada em troca
     */
    public void trocarFigurinha(Figurinha figurinhaQueEntra, Figurinha figurinhaQueSai) {
        int posicao = figurinhaQueSai.getPosicao();
        if (getContadorRepetidas(posicao) == 0) {
            return;  // a troca não será possível
        }
        receberFigurinha(figurinhaQueEntra);
        this.repetidas[posicao]--;
        this.contRepetidas--;
    }

    /**
     * @return O total de figurinhas (distintas) que já fazem parte do álbum.
     */
    public int getContadorFigurinhas() {
        return this.contFigurinhas;
    }

    /**
     * @return O total de figurinhas repetidas.
     */
    public int getContadorRepetidas() {
        return this.contRepetidas;
    }

    /**
     * @param numeroDaFigurinha O número da figurinha desejada.
     * @return A quantidade de repetidas da figurinha desejada.
     */
    public int getContadorRepetidas(int numeroDaFigurinha) {
        return this.repetidas[numeroDaFigurinha];
    }

    /**
     * Indica se já é possível solicitar figurinhas específicas à editora, diretamente.
     *
     * @return true; caso seja possível; false, caso o álbum ainda não esteja
     *         cheio o suficiente.
     */
    public boolean isFinalizacaoPreenchimentoPossivel() {
        return false;  // ToDo IMPLEMENT ME!!!
    }

    /**
     * Retorna a figurinha da posição dada.
     *
     * @param posicao A posição desejada.
     * @return A Figurinha que ocupa
     */
    public Figurinha getFigurinha(int posicao) {
        return this.figurinhas[posicao];
    }
}
