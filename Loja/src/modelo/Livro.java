package modelo;

public class Livro {

    private static final float PRECO_DEFAULT = 10;

    private String titulo;

    private Pessoa autor;

    private int anoPublicacao;

    private float preco;

    public Livro(String titulo, Pessoa autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.preco = PRECO_DEFAULT;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getDescricao() {
        return String.format("%s, by %s (%d)",
                this.titulo, this.autor, this.anoPublicacao);
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getPreco() {
        return this.preco;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
}
