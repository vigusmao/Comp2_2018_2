package dominio;

public class Album {

    /**
     * Um array de booleanos, onde a posição k indicará se a figura k pertence (true)
     * ou não (false) ao álbum.
     */
    private boolean[] figurinhas;

    private int contFigurinhas;

    /** Um array de inteiros, onde a posição k indicará a quantidade de repetidas da
     * figurinha k.
     */
    private int[] repetidas;

    private int contRepetidas;



    /**
     * @param tamanho O número total de figurinhas do álbum.
     */
    public Album(int tamanho) {
        super();
        this.figurinhas = new boolean[tamanho + 1];  // descartaremos a posição 0
        this.repetidas = new int[tamanho + 1];  // idem
        this.contFigurinhas = 0;
    }

    /**
     * Retorna se determinada figurinha existe no álbum.
     * @param numeroDaFigurinha a figurinha desejada
     * @return true, se a figurinha existir no álbum; false, caso contrário
     */
    public boolean possuiFigurinha(int numeroDaFigurinha) {
        return this.figurinhas[numeroDaFigurinha];
    }

    /**
     * Processa uma figurinha recém-adquirida, acrescento-a ao álbum, caso
     * seja inédita, ou ao monte de figurinhas repetidas, caso não seja.
     *
     * @param numeroDaFigurinha O número (posição) da figurinha recebida.
     */
    public void receberFigurinha(int numeroDaFigurinha) {
        if (this.figurinhas[numeroDaFigurinha]) {
            // figurinha repetida!
            this.repetidas[numeroDaFigurinha]++;
            this.contRepetidas++;

        } else {
            // figurinha inédita!
            this.figurinhas[numeroDaFigurinha] = true;
            this.contFigurinhas++;
        }
    }

    /**
     * Indica se o álbum está cheio.
     *
     * @return true, caso esteja cheio; false, caso contrário.
     */
    public boolean isCheio() {
        return false;  // ToDo IMPLEMENT ME!!!
    }

    /**
     * Recebne uma figurinha, e fornece outra em troca.
     * A figurinha que sai precisa ser uma figurinha repetida; do contrário,
     * o método não fará nada.
     * @param figurinhaQueEntra a nova figurinha (não precisa ser inédita)
     * @param figurinhaQueSai a figurinha que é dada em troca
     */
    public void trocarFigurinha(int figurinhaQueEntra, int figurinhaQueSai) {
        // ToDo IMPLEMENT ME!!!
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
}
