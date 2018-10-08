import java.util.*;

public class Banco {

    private Map<Long, Conta> contasCorrentes;
//    private List<Conta> contasCorrentes;
    private long seqNum;

    public Banco() {
        this.contasCorrentes = new HashMap<>();
//        this.contasCorrentes = new ArrayList<>();
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
        return this.contasCorrentes.get(numeroDaConta);
//        for (Conta conta : this.contasCorrentes) {
//            if (conta.getNumeroDaConta() == numeroDaConta) {
//                return conta;
//            }
//        }
//        return null;
    }

    public Conta abrirConta(Pessoa dono) {
        this.seqNum++;
        Conta novaConta = new Conta(seqNum, dono);
        this.contasCorrentes.put(novaConta.getNumeroDaConta(), novaConta);
//        this.contasCorrentes.add(novaConta);
        return novaConta;
    }

    public static void main(String args[]) {
        Random random = new Random();
        Banco bancoUnico = new Banco();
        Pessoa magnata = new PessoaFisica(12345);
        for (int i = 0; i < 4_000_000; i++) {
            Conta novaConta = bancoUnico.abrirConta(magnata);
            long valorAleatorio = Math.abs(random.nextLong());
            novaConta.depositar(valorAleatorio);
        }

        int tamanhoBusca = 100_000_000;
        long inicio = System.currentTimeMillis();
        for (int numero = 5_000_000; numero < 5_000_000 + tamanhoBusca; numero++) {
            Conta conta = bancoUnico.getConta(numero);
            if (conta != null && conta.getNumeroDaConta() < 10) {
                System.out.println("Encontrei conta com numero pequeno!");
            }
        }
        long duracao = System.currentTimeMillis() - inicio;
        System.out.printf("Fiz %d buscas e levei %d milissegundos",
                tamanhoBusca, duracao);
    }
}
