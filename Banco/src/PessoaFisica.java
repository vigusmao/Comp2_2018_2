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
}
