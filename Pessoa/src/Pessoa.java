import java.util.Calendar;
import java.util.Date;

/**
 * Esta classe modela um indivíduo, com nome, CPF e ano de nascimento.
 */
public class Pessoa {

    protected String nome;
    private long cpf;
    private final int anoDeNascimento;

    public Pessoa(String nome, int anoDeNascimento) {
        this.nome = nome;
        this.anoDeNascimento = anoDeNascimento;
    }

    /** Retorna a idade da pessoa no último dia do ano corrente. */
    public int getIdade() {
        int anoCorrente = Utils.getAnoCorrente();
        return 0;  // ToDo
    }

    public String getNome() {
        return null;  // ToDo
    }

    public long getCpf() {
        return 0;  // ToDo
    }

    public void setCpf(long cpf) {
        // ToDo
    }
}
