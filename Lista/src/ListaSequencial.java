public class ListaSequencial<T extends Publicacao> extends Lista<T> {

    private Object[] elementos;

    public ListaSequencial(int maxCapacity) {
        super(maxCapacity);
        this.elementos = new Object[maxCapacity];
    }

    @Override
    protected void efetuarAdicaoDeElemento(T elemento) {
        this.elementos[getSize()] = elemento;
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
}
