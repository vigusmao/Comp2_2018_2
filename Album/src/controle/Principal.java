package controle;

import dominio.*;

public class Principal {

    public static void main(String[] args) {
        final int tamanhoAlbum = 400;
        final int figurinhasPorPacote = 3;
        final int nRepeticoes = 1000;
        final Cartao meuCartao = new Cartao(2222);
        final Pessoa pessoa = new Pessoa("Ze", 11111);
        final ContaBancaria conta = new ContaBancaria(pessoa, "Dólar");

        Editora minhaEditora = new Editora(figurinhasPorPacote, tamanhoAlbum);

        long totalPacotinhosCompradosSimulacao = 0;
        long totalFigurinhasCompradasSimulacao = 0;

        for (int i = 0; i < nRepeticoes; i++) {
            Album<Figurinha> album = new Album<>(tamanhoAlbum);
            Figurinha fig = new Figurinha(6, "bla");
            album.receberItem(fig);
            int contFigurinhas = 0;
            int contPacotinhos = 0;
            while (!album.isCheio()) {
                Colecionavel[] pacotinho = minhaEditora.adquirirPacotinhoAleatorio();
                contPacotinhos++;
                for (Colecionavel figurinha : pacotinho) {
                    album.receberItem((Figurinha) figurinha);
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
