import java.util.Objects;

public class Livro implements Publicacao {

    private String titulo;

    private int nPaginas;

    public Livro(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(titulo, livro.titulo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(titulo);
    }

    @Override
    public int getNumeroDePaginas() {
        return this.nPaginas;
    }
}
