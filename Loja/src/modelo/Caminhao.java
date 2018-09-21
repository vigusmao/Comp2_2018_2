package modelo;

import java.util.Calendar;

public class Caminhao extends Veiculo implements Vendavel, Transportador {

    private String marca;

    private final int anoFabricacao;

    private float preco = -1;

    public Caminhao(String marca) {
        inicializarCaminhao(marca);
        Calendar calendar = Calendar.getInstance();
        int anoCorrente = calendar.get(Calendar.YEAR);
        this.anoFabricacao = anoCorrente;
    }

    public Caminhao(String marca, int anoFabricacao) {
        inicializarCaminhao(marca);
        this.anoFabricacao = anoFabricacao;
    }

    private void inicializarCaminhao(String marca) {
        this.marca = marca;
        // Possivelmente muitas outras linhas inicializando coisas...
    }

    public void entregar(Vendavel item,
                         String endereco) {
        System.out.printf("Levando o item %s de caminhão " +
                "para o endereço %s...\n",
                item.getDescricao(), endereco);
        andar(60);
    }

    public float getPreco() {
        if (this.preco == -1) {  // nunca foi calculado
            // lazy instantiation
            inicializarPreco();
        }
        return this.preco;
    }

    public String getDescricao() {
        return String.format("Caminhão %s fabricado em %d",
                this.marca, this.anoFabricacao);
    }

    private void inicializarPreco() {
        // regra louca para calcular precos
        this.preco = anoFabricacao * 500;
    }


}
