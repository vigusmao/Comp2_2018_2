package dominio;

public class Figurinha implements Colecionavel {

    private final int posicao;

    private String urlDaImagem;

    private int larguraEmMilimetros;

    private int alturaEmMilimetros;

    private float frequenciaRelativa;

    public Figurinha(int posicao) {
        this.posicao = posicao;
    }

    public Figurinha(int posicao, String urlDaImagem) {
        this.posicao = posicao;
        this.urlDaImagem = urlDaImagem;
    }

    public int getPosicao() {
        return this.posicao;
    }

    public float getTamanho() {
        return this.larguraEmMilimetros * this.alturaEmMilimetros / 100;
    }

    public String getUrlDaImagem() {
        return this.urlDaImagem;
    }
}
