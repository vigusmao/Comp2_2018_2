package controle;

import dominio.Album;
import dominio.Editora;
import dominio.Figurinha;

public class Principal {

    public static void main(String[] args) {
        final int tamanhoAlbum = 400;
        final int figurinhasPorPacote = 3;
        final int nRepeticoes = 1000;

        Editora minhaEditora = new Editora(figurinhasPorPacote, tamanhoAlbum);

        long totalPacotinhosCompradosSimulacao = 0;
        long totalFigurinhasCompradasSimulacao = 0;

        for (int i = 0; i < nRepeticoes; i++) {
            Album album = new Album(tamanhoAlbum);
            int contFigurinhas = 0;
            int contPacotinhos = 0;
            while (!album.isCheio()) {
                Figurinha[] pacotinho = minhaEditora.adquirirPacotinhoAleatorio();
                contPacotinhos++;
                for (Figurinha figurinha : pacotinho) {
                    album.receberFigurinha(figurinha);
                    contFigurinhas++;
                }
            }
            totalPacotinhosCompradosSimulacao += contPacotinhos;
            totalFigurinhasCompradasSimulacao += contFigurinhas;
        }

        float mediaPacotinhosComprados =
                ((float) totalPacotinhosCompradosSimulacao) / nRepeticoes;
        float mediaFigurinhasCompradas =
                ((float) totalFigurinhasCompradasSimulacao) / nRepeticoes;

        System.out.printf("Tamanho do álbum: %d\n", tamanhoAlbum);
        System.out.printf("Pacotinhos comprados em média: %.1f\n",
                mediaPacotinhosComprados);
        System.out.printf("Figurinhas compradas em média: %.1f\n",
                mediaFigurinhasCompradas);
    }
}
