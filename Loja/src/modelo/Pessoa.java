package modelo;

public class Pessoa implements Transportador {

    protected String nome;

    private long cpf;

    private final int anoNascimento;

    public Pessoa(String nome, int anoNascimento) {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void respirar() {
        System.out.println("Estou respirando...");
    }

    @Override
    public String toString() {
        return this.nome;
    }

    @Override
    public void entregar(Vendavel item, String endereco) {
        System.out.printf("Sou o %s e estou levando o item %s com as mãos e pés " +
                        "para o endereço %s...\n",
                this.nome, item.getDescricao(), endereco);
    }
}
