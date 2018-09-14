package controle;

import modelo.*;

public class Principal {

    public static void main(String[] args) {

        Pessoa autor = new Pessoa("Machado de Assis", 1880);
        Caminhao meuCaminhao = new Caminhao("Jamanta");

        Pessoa carregador;
        carregador = new Aluno("Jarbas", 1960, 12222);
        carregador.respirar();  // qualquer Aluno é uma Pessoa, portanto respira
        // Mas não poderíamos fazer, por exemplo, "carregador.estudar()", porque nem toda Pessoa é Aluno.

        Loja minhaLoja = new Loja(carregador);

        /* Note que, do ponto de vista do main(), carregador é uma Pessoa, pois foi declarado como tal;
           do ponto de vista da Loja, carregador é simplesmente "algo" que implementa a interface Transportador,
           pois o construtor de Loja espera receber um Transportador como parâmetro;
           e, finalmente, do ponto de vista do próprio carregador, ele é de fato um Aluno (e, por herança, uma Pessoa),
           e portanto, sendo um Aluno, ele fará as coisas da forma como alunos fazem (sempre que houver um @Override em
           Aluno, claro).
        */


        for (int i = 1; i <= 10; i++) {
            Livro livro = new Livro(
                    String.format("Livro%d", i), autor);
            livro.setAnoPublicacao(1920 + i);
            minhaLoja.adicionarItemAVitrine(livro);
        }

        for (int i = 1; i <= 5; i++) {
            Caminhao caminhao = new Caminhao("Scannia", 2000 + i);
            minhaLoja.adicionarItemAVitrine(caminhao);
        }

        System.out.println(minhaLoja.getVitrineAsString());

        Livro livroDesejado = new Livro("Livro2", autor);
        Livro outroLivroDesejado = livroDesejado.clone();

        String meuEndereco = "Minha Rua, 1234";

        // Compraremos agora todos os livros da loja
        for (Vendavel vendavel : minhaLoja.getVitrine()) {
            if (vendavel instanceof Livro) {
                // Faremos um type cast aqui. Cuidado com erros em tempo de execução!!!!!
                Livro livro = (Livro) vendavel;
                minhaLoja.efetuarVenda(livro, meuEndereco, 765432);
            }
        }
    }
}
