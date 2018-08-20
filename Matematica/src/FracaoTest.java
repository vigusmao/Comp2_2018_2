import org.junit.Test;

import static org.junit.Assert.*;

public class FracaoTest {

    @Test
    public void ehPropriaTest() {
        assertTrue((new Fracao(2, 5)).ehPropria());
        assertFalse((new Fracao(7, 4)).ehPropria());
        assertFalse((new Fracao(8, 8)).ehPropria());
    }

    @Test
    public void toStringTest() {
        assertEquals("2" + Fracao.getSeparador() + "7",
                (new Fracao(2, 7)).toString());
    }

    @Test
    public void equalsTestParaFracoesIdenticas() {
        assertEquals(new Fracao(1, 2), new Fracao(1, 2));
        assertEquals(new Fracao(-1, 2), new Fracao(1, -2));

        // equivalentemente...
        assertTrue((new Fracao(1, 2)).equals(new Fracao(1, 2)));
        assertTrue((new Fracao(-1, 2)).equals(new Fracao(1, -2)));
    }

    @Test
    public void equalsTestParaFracoesEquivalentes() {
        assertEquals(new Fracao(1, 2), new Fracao(2, 4));
        assertNotEquals(new Fracao(1, 2), new Fracao(-2, 4));
    }

    @Test
    public void getFracaoIrredutivelTestParaFracaoPositiva() {
        Fracao fracaoOriginal = new Fracao(10, 20);
        Fracao fracaoIrredutivelObtida = fracaoOriginal.getFracaoIrredutivel();
        assertEquals(1, fracaoIrredutivelObtida.getNumerador());
        assertEquals(2, fracaoIrredutivelObtida.getDenominador());
        assertTrue(fracaoIrredutivelObtida.isPositiva());

    }

    @Test
    public void getFracaoIrredutivelTestParaFracaoNegativa() {
        Fracao fracaoOriginal = new Fracao(-10, 20);
        Fracao fracaoIrredutivelObtida = fracaoOriginal.getFracaoIrredutivel();
        assertEquals(1, fracaoIrredutivelObtida.getNumerador());
        assertEquals(2, fracaoIrredutivelObtida.getDenominador());
        assertFalse(fracaoIrredutivelObtida.isPositiva());

    }

    @Test
    public void calcularMaximoDivisorComumTest() {
        assertEquals(2, Fracao.calcularMaximoDivisorComum(124, 6));
        assertEquals(2, Fracao.calcularMaximoDivisorComum(6, 124));
        assertEquals(1, Fracao.calcularMaximoDivisorComum(26, 125));
    }
}