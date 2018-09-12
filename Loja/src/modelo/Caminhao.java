package modelo;

public class Caminhao {

    public void entregar(Livro livro,
                         String endereco) {
        System.out.printf("Entregando o livro %s " +
                "no endereço %s...\n",
                livro.getDescricao(), endereco);
    }
}
