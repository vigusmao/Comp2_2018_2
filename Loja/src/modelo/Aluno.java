package modelo;

public class Aluno extends Pessoa {

    private long dre;

    public Aluno(String nome, int anoNascimento, long dre) {
        super(nome, anoNascimento);
        this.dre = dre;
    }

    public void estudar() {
        System.out.println("Estou estudando...");
    }

    @Override
    public void entregar(Vendavel item, String endereco) {
        System.out.printf("Sou o %s e estou levando DESESPERADAMENTE (porque tenho que estudar!!!!)" +
                        " o item %s para o endereço %s...\n",
                this.nome, item.getDescricao(), endereco);
    }
}
