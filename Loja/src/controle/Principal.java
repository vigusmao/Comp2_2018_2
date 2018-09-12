package controle;

import modelo.Caminhao;
import modelo.Livro;
import modelo.Loja;
import modelo.Pessoa;

public class Principal {

    public static void main(String[] args) {

        Caminhao meuCaminhao = new Caminhao();
        Loja minhaLoja = new Loja(meuCaminhao);

        Pessoa autor = new Pessoa("Machado de Assis", 1880);

        for (int i = 1; i <= 10; i++) {
            Livro livro = new Livro(
                    String.format("Livro%d", i), autor);
            livro.setAnoPublicacao(1920 + i);
            minhaLoja.adicionarItemAVitrine(livro);
        }

        System.out.println(minhaLoja.getVitrine());
    }
}
