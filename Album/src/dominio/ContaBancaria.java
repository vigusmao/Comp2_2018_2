package dominio;

public class ContaBancaria implements MeioDePagamento{

    private Pessoa correntista;

    private String moeda;

    private float saldo;

    public ContaBancaria(Pessoa correntista, String moeda) {
        this.moeda = moeda;
        this.correntista = correntista;
    }

    public void sacar(float valor) {
        this.saldo -= valor;
    }

    @Override
    public void pagar(float valor, String moeda) {
        if (!moeda.equals(this.moeda)) {
            // lança uma exceção
            System.out.printf("Moeda inválida!!!! A conta é em %s!!!!\n",
                    this.moeda);
            return;
        }
        sacar(valor);
        System.out.printf("Saquei %s %.2f e vou efetuar o pagamento " +
                "desejado...\n", moeda, valor);
    }
}
