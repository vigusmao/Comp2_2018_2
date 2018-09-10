package dominio;

public class Album {

    /**
     * Um array de Colecionavel, onde na posição k teremos o item
     * cujo atributo `posicao` é k; ou null, caso não tenhamos o item
     * em questão.
     */
    private Colecionavel[] items;

    private int contItems;

    /** Um array de inteiros, onde a posição k indicará a quantidade de repetidos do
     * item k.
     */
    private int[] repetidos;

    private int contRepetidos;

    /** O total de items do álbum completo.
     */
    private final int tamanho;

    /**
     * @param tamanho O número total de items do álbum.
     */
    public Album(int tamanho) {
        super();
        this.tamanho = tamanho;
        this.items = new Colecionavel[tamanho + 1];  // descartaremos a posição 0
        this.repetidos = new int[tamanho + 1];  // idem
        this.contItems = 0;
    }

    /**
     * Retorna se determinado item existe no álbum.
     * @param posicao a posição do item desejado
     * @return true, se o item desejado existir no álbum; false, caso contrário
     */
    public boolean possuiItem(int posicao) {
        return this.items[posicao] != null;
    }

    /**
     * Processa um item recém-adquirido, acrescentando-o ao álbum, caso
     * seja inédito, ou ao monte de items repetidos, caso não seja.
     *
     * @param item O item a ser recebido.
     */
    public void receberItem(Colecionavel item) {
        int posicao = item.getPosicao();
        if (this.items[posicao] != null) {
            // item repetido!
            this.repetidos[posicao]++;
            this.contRepetidos++;

        } else {
            // item inédito!
            this.items[posicao] = item;
            this.contItems++;
        }
    }

    /**
     * Indica se o álbum está cheio.
     *
     * @return true, caso esteja cheio; false, caso contrário.
     */
    public boolean isCheio() {
        return this.contItems == this.tamanho;
    }

    /**
     * Recebe um item e fornece outro em troca.
     * O item que sai precisa ser um item repetida; do contrário,
     * o método não fará nada.
     * @param itemQueEntra o nova item (não precisa ser inédito)
     * @param itemQueSai o item que é dado em troca
     */
    public void trocarItem(Colecionavel itemQueEntra, Colecionavel itemQueSai) {
        int posicao = itemQueSai.getPosicao();
        if (getContadorRepetidos(posicao) == 0) {
            return;  // a troca não será possível
        }
        receberItem(itemQueEntra);
        this.repetidos[posicao]--;
        this.contRepetidos--;
    }

    /**
     * @return O total de items (distintos) que já fazem parte do álbum.
     */
    public int getContadorItems() {
        return this.contItems;
    }

    /**
     * @return O total de items repetidos.
     */
    public int getContadorRepetidos() {
        return this.contRepetidos;
    }

    /**
     * @param posicao A posição do item desejado.
     * @return A quantidade de repetidos do item desejado.
     */
    public int getContadorRepetidos(int posicao) {
        return this.repetidos[posicao];
    }

    /**
     * Indica se já é possível solicitar items específicos à editora, diretamente.
     *
     * @return true; caso seja possível; false, caso o álbum ainda não esteja
     *         cheio o suficiente.
     */
    public boolean isFinalizacaoPreenchimentoPossivel() {
        return false;  // ToDo IMPLEMENT ME!!!
    }

    /**
     * Retorna o item da posição dada.
     *
     * @param posicao A posição desejada.
     * @return O item que ocupa a posição dada, se existir; ou null, caso contrário
     */
    public Colecionavel getItem(int posicao) {
        return this.items[posicao];
    }
}
