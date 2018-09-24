package dominio;

public class Selo implements Colecionavel {

    private final int posicao;

    private float valorNominal;

    private String paisDeOrigem;

    public Selo(int posicao, String paisDeOrigem) {
        this.posicao = posicao;
        this.paisDeOrigem = paisDeOrigem;
    }

    public int getPosicao() {
        return this.posicao;
    }

    public String getUrlDaImagem() {
        return null;
    }
}
