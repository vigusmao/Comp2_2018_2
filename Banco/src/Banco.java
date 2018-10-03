import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Banco {

    private List<Conta> contasCorrentes;
    private long seqNum;

    public Banco() {
        this.contasCorrentes = new ArrayList<>();
    }

    /**
     * Retorna o saldo da conta cujo número foi informado.
     *
     * @param numeroDaConta o número da conta desejada
     * @return o saldo da conta, se essa conta existir;
     *         0, caso contrário
     */
    public double getSaldo(long numeroDaConta) {
        Conta contaDesejada = getConta(numeroDaConta);
        if (contaDesejada != null) {
            return contaDesejada.getSaldo();
        }
        return 0;  // o correto aqui é lançar uma exceção!
    }

    public Conta getConta(long numeroDaConta) {
        for (Conta conta : this.contasCorrentes) {
            if (conta.getNumeroDaConta() == numeroDaConta) {
                return conta;
            }
        }
        return null;
    }

    public Conta abrirConta(Pessoa dono) {
        this.seqNum++;
        Conta novaConta = new Conta(seqNum, dono);
        this.contasCorrentes.add(novaConta);
        return novaConta;
    }

    public static void main(String args[]) {
        Random random = new Random();
        Banco bancoUnico = new Banco();
        Pessoa magnata = new PessoaFisica(12345);
        for (int i = 0; i < 64_000; i++) {
            Conta novaConta = bancoUnico.abrirConta(magnata);
            long valorAleatorio = Math.abs(random.nextLong());
            novaConta.depositar(valorAleatorio);
        }
        Conta umaConta = bancoUnico.getConta(222);
        System.out.printf("Saldo da conta 222 = %.2f\n",
                umaConta.getSaldo());
        umaConta.depositar(500);
        System.out.printf("Saldo da conta 222 = %.2f\n",
                umaConta.getSaldo());

        // Vamos descobrir se há duas contas com o mesmo saldo
        long inicio = System.currentTimeMillis();
        int nContas = bancoUnico.contasCorrentes.size();
        boolean encontrei = false;
        for (int i = 0; i < nContas; i++) {
            Conta conta = bancoUnico.contasCorrentes.get(i);
            double saldo = conta.getSaldo();
            for (int j = i+1; j < nContas; j++) {
                Conta outraConta = bancoUnico.contasCorrentes.get(j);
                if (outraConta.getSaldo() == saldo) {
                    // encontrei!!!!!
                    System.out.printf("Encontrei! As contas " +
                            "%d e %d têm ambas o saldo %.2f\n",
                            conta.getNumeroDaConta(),
                            outraConta.getNumeroDaConta(),
                            saldo);
                    encontrei = true;
                    break;
                }
            }
            if (encontrei) {
                break;
            }
        }
        if (!encontrei) {
            System.out.println("Não encontrei!");
        }
        long duracao = System.currentTimeMillis() - inicio;
        System.out.printf("Duracao = %d milissegundos\n", duracao);


        // Como fazer isso de um jeito MUITO mais eficiente?????
    }
}
