package controle;

import dominio.*;

import java.util.ArrayList;
import java.util.List;

public class Principal {

    public static void main(String[] args) {

        int meuArray[] = new int[5];
        meuArray[2] = 200;
        System.out.println("meuArray[2] = " + meuArray[2]);

        Integer x = 3;
        Integer y = x;
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        x += 2;
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        List<Integer> minhaLista = new ArrayList<>(200);
        for (int i = 0; i < 200; i++) {
            minhaLista.add(null);
        }
        System.out.println("minhaLista.size() = " + minhaLista.size());
        minhaLista.set(2, 333);
        System.out.println("minhaLista.get(2) = " + minhaLista.get(2));



//        final int tamanhoAlbum = 400;
//        final int figurinhasPorPacote = 3;
//        final int nRepeticoes = 1000;
//        final Cartao meuCartao = new Cartao(2222);
//        final Pessoa pessoa = new Pessoa("Ze", 11111);
//        final ContaBancaria conta = new ContaBancaria(pessoa, "Dólar");
//
//        Editora minhaEditora = new Editora(figurinhasPorPacote, tamanhoAlbum);
//
//        long totalPacotinhosCompradosSimulacao = 0;
//        long totalFigurinhasCompradasSimulacao = 0;
//
//        for (int i = 0; i < nRepeticoes; i++) {
//            Album<Figurinha> album = new Album<>(tamanhoAlbum);
//            Figurinha fig = new Figurinha(6, "bla");
//            album.receberItem(fig);
//            int contFigurinhas = 0;
//            int contPacotinhos = 0;
//            while (!album.isCheio()) {
//                Colecionavel[] pacotinho = minhaEditora.adquirirPacotinhoAleatorio();
//                contPacotinhos++;
//                for (Colecionavel figurinha : pacotinho) {
//                    album.receberItem((Figurinha) figurinha);
//                    contFigurinhas++;
//                }
//            }
//            totalPacotinhosCompradosSimulacao += contPacotinhos;
//            totalFigurinhasCompradasSimulacao += contFigurinhas;
//        }
//
//        float mediaPacotinhosComprados =
//                ((float) totalPacotinhosCompradosSimulacao) / nRepeticoes;
//        float mediaFigurinhasCompradas =
//                ((float) totalFigurinhasCompradasSimulacao) / nRepeticoes;
//
//        System.out.printf("Tamanho do álbum: %d\n", tamanhoAlbum);
//        System.out.printf("Pacotinhos comprados em média: %.1f\n",
//                mediaPacotinhosComprados);
//        System.out.printf("Figurinhas compradas em média: %.1f\n",
//                mediaFigurinhasCompradas);
    }


}
