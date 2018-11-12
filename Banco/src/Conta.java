import java.util.List;

public class Conta {

    private long numeroDaConta;
    private Pessoa dono;
    private double saldo;

    public Conta(long numeroDaConta,
                 Pessoa dono) {
        this.numeroDaConta = numeroDaConta;
        this.dono = dono;
        this.saldo = 10;
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

    public void depositarEmEspecie(List<Dinheiro> notasEMoedas) {
        float valorDoDeposito = 0;
        for (Dinheiro dinheiro : notasEMoedas) {
            valorDoDeposito = dinheiro.getValorEmReais();
            depositar(valorDoDeposito);
        }
    }

//    public void verificarValor(float valor)
//            throws DinheiroNegativoException,
//                   MoedaInvalidaException,
//                   CedulaInvalidaException {
//
//        if (valor < 0) {
//            throw new DinheiroNegativoException();
//        }
//        if (valor <= 1) {
//            switch (valor) {
//                case 0.05f: case 0.10f: case 0.25f: case 0.50f: case 1:
//                    return;
//                default: throw new MoedaInvalidaException();
//            }
//
//        } else {
//            if (valor == 2 ||
//                    valor == 5 ||
//                    valor == 20) {
//                return;
//            }
//            throw new CedulaInvalidaException();
//        }
//    }

    public void sacar(double valor) {
        this.saldo -= valor;
    }
}
