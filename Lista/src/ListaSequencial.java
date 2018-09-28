public class ListaSequencial<T extends Publicacao> extends Lista<T> {

    private Object[] elementos;

    private int totalEscritas = 0;

    public ListaSequencial(int maxCapacity) {
        super(maxCapacity);
        this.elementos = new Object[16];
    }

    @Override
    protected void efetuarAdicaoDeElemento(T elemento) {
        int contElementosAtual = getSize();
        int tamanhoDoArray = this.elementos.length;

        if (contElementosAtual == tamanhoDoArray) {  // array cheio!!!!
            // preciso criar outro array...
            Object[] novoArray = new Object[tamanhoDoArray * 2];
            // ...e copiar tudo lá pra dentro
            for (int i = 0; i < tamanhoDoArray; i++) {
                novoArray[i] = this.elementos[i];
                totalEscritas++;
            }
            // agora aponto para o novo array
            this.elementos = novoArray;
        }
        this.elementos[contElementosAtual] = elemento;
        totalEscritas++;
    }

    @Override
    protected T efetuarLeitura(int index) {
        return (T) this.elementos[index];
    }

    @Override
    protected void efetuarRemocao(int index) {
        int currentSize = getSize();
        for (int i = index; i <= currentSize - 2; i++) {
            this.elementos[i] = this.elementos[i+1];
        }
        this.elementos[currentSize - 1] = null;
    }

    public int getTotalDeEscritas() {
        return this.totalEscritas;
    }
}
