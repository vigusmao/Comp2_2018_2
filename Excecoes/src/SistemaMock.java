public class SistemaMock extends Sistema {

    String senhaASerRetornada1;
    String senhaASerRetornada2;

    public void setSenhaASerRetornada1(String senhaASerRetornada1) {
        this.senhaASerRetornada1 = senhaASerRetornada1;
    }

    public void setSenhaASerRetornada2(String senhaASerRetornada2) {
        this.senhaASerRetornada2 = senhaASerRetornada2;
    }

    @Override
    String obterSenha() {
        return senhaASerRetornada1;
    }

    @Override
    String obterSenhaDeNovo() {
        return senhaASerRetornada2;
    }

}
