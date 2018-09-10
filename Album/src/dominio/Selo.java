package dominio;

public class Selo implements Colecionavel {

    private final int posicao;

    private float valorNominal;

    private String paisDeOrigem;

    public Selo(int posicao) {
        this.posicao = posicao;
    }

    public int getPosicao() {
        return this.posicao;
    }

    public String getUrlDaImagem() {
        return null;
    }
}
