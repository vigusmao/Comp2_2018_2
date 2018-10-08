import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class PositiveIntegerSetOverBoleanArray implements Set<Integer> {

    private boolean[] elementos;
    private int maxAllowedElement;
    private int size;

    public PositiveIntegerSetOverBoleanArray(int maxAllowedElement) {
        this.maxAllowedElement = maxAllowedElement;
        this.elementos = new boolean[maxAllowedElement + 1];
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (!(o instanceof Integer)) {
            return false;
        }
        int indice = (int) o;
        if (indice < 0 || indice > this.maxAllowedElement) {
            return false;
        }
        return this.elementos[indice];
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];  // ToDo IMPLEMENT ME!  (poderia lançar execeção)
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;  // ToDo IMPLEMENT ME!  (poderia lançar execeção)
    }

    @Override
    public boolean add(Integer integer) {
        boolean jaExiste = this.elementos[integer];
        if (!jaExiste) {
            this.elementos[integer] = true;
            this.size++;
        }
        return !jaExiste;
    }

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof Integer)) {
            return false;
        }
        int indice = (int) o;
        boolean existia = this.elementos[indice];
        if (existia) {
            this.elementos[indice] = false;
            this.size--;
        }
        return existia;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;  // ToDo IMPLEMENT ME!  (poderia lançar execeção)
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        return false;  // ToDo IMPLEMENT ME!  (poderia lançar execeção)
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;  // ToDo IMPLEMENT ME!  (poderia lançar execeção)
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;  // ToDo IMPLEMENT ME!  (poderia lançar execeção)
    }

    @Override
    public void clear() {
        for (int i = 0; i <= this.maxAllowedElement; i++) {
            this.elementos[i] = false;
        }
        this.size = 0;
    }
}
