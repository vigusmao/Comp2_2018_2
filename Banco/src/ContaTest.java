import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ContaTest {

    private final static float DELTA = 0.00001f;

    Conta conta;
    Pessoa correntista;

    @Before
    public void setUp() {
        correntista = new PessoaFisica(222222L);
        conta = new Conta(1234L, correntista);
    }

    @Test
    public void testeDepositoEmEspecie() {

        // sanity check
        assertEquals("Novas contas devem ser criadas com saldo 10",
                10, conta.getSaldo(), DELTA);

        List<Dinheiro> listaComAGrana = new ArrayList<>();
        listaComAGrana.add(Dinheiro.NOTA_DE_VINTE_REAIS);
        listaComAGrana.add(Dinheiro.NOTA_DE_DOIS_REAIS);
        listaComAGrana.add(Dinheiro.NOTA_DE_DOIS_REAIS);
        listaComAGrana.add(Dinheiro.MOEDA_DE_CINQUENTA_CENTAVOS);

        conta.depositarEmEspecie(listaComAGrana);

        assertEquals(24.50f, conta.getSaldo(), DELTA);
    }

    @Test
    public void testeMaluco() {
        assertEquals(Dinheiro.NOTA_DE_VINTE_REAIS,
                Dinheiro.valueOf("NOTA_DE_VINTE_REAIS"));

        assertTrue(Dinheiro.verificarValor(1));
        assertTrue(Dinheiro.verificarValor(2));
        assertTrue(Dinheiro.verificarValor(5));
        assertTrue(Dinheiro.verificarValor(0.5f));
        assertFalse(Dinheiro.verificarValor(3));
        assertFalse(Dinheiro.verificarValor(0.17f));


    }
}