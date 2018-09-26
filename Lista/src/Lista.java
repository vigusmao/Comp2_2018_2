public abstract class Lista {

    private int size;

    private int maxCapacity;

    public Lista(int maxCapacity) {
        this.size = 0;
        this.maxCapacity = maxCapacity;
    }

    /**
     * Acrescenta um elemento ao final da lista.
     * @param elemento O elemento desejado.
     */
    public void add(Object elemento) {
        if (size == maxCapacity) {
            System.out.println("Capacidade máxima atingida. " +
                    "Não vou adicionar.");
            return;  // o correto seria lançar uma exceção!
        }
        efetuarAdicaoDeElemento(elemento);
        size++;
    }

    public Object get(int index) {
        if (index >= size) {
            System.out.println("Posição inválida! Nada a ser lido.");
            return null;  // o correto seria lançar uma exceção!
        }
        return efetuarLeitura(index);
    }

    public void remove(int index) {
        if (index >= size) {
            System.out.println("Posição inválida! Nao vou remover.");
            return;  // o correto seria lançar uma exceção!
        }
        efetuarRemocao(index);
        this.size--;
    }

    public int getSize() {
        return this.size;
    }

    protected abstract void efetuarAdicaoDeElemento(Object elemento);

    protected abstract Object efetuarLeitura(int index);

    protected abstract void efetuarRemocao(int index);
}
