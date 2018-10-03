public class Conta {

    private long numeroDaConta;
    private Pessoa dono;
    private double saldo;

    public Conta(long numeroDaConta,
                 Pessoa dono) {
        this.numeroDaConta = numeroDaConta;
        this.dono = dono;
        this.saldo = 0;
        dono.addConta(this);
    }

    public long getNumeroDaConta() {
        return this.numeroDaConta;
    }

    public Pessoa getDono() {
        return this.dono;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void depositar(double valor) {
//        System.out.printf("Depositando %.2f reais...\n",
//                valor);
        this.saldo += valor;
    }

    public void sacar(double valor) {
        this.saldo -= valor;
    }
}
