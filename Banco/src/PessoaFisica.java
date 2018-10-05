import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PessoaFisica extends Pessoa {

    private long cpf;

    public PessoaFisica(long cpf) {
        // super()  não é necessário;
        //          será colocado automaticamente!
        this.cpf = cpf;
    }

    @Override
    public long getId() {
        return this.cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaFisica that = (PessoaFisica) o;
        return cpf == that.cpf;
    }

    @Override
    public int hashCode() {

        return Objects.hash(cpf);
    }

    public static void main(String[] args) {
        Map<PessoaFisica, Long> telefoneByPessoa;
        telefoneByPessoa = new HashMap<>();

        PessoaFisica fulano = new PessoaFisica(1234);
        telefoneByPessoa.put(fulano, 99999999L);

        PessoaFisica outraInstanciaDeFulano = new PessoaFisica(1234);

        System.out.println("O telefone do fulano é " +
            telefoneByPessoa.get(outraInstanciaDeFulano));

    }
}
