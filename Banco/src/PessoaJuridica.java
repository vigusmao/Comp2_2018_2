public class PessoaJuridica extends Pessoa {

    private long cnpj;

    public PessoaJuridica(long cnpj) {
        // super()  não é necessário;
        //          será colocado automaticamente!
        this.cnpj = cnpj;
    }

    @Override
    public long getId() {
        return this.cnpj;
    }
}

