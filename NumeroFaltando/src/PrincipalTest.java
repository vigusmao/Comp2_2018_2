import org.junit.Assert;
import org.junit.Test;

public class PrincipalTest {

    @Test
    public void encontrarNumeroAusenteTest() {
        Assert.assertEquals("O número ausente não foi encontrado",
                2, Principal.encontrarNumeroAusente(new int[] {0, 4, 1, 3}));
        Assert.assertEquals("O número ausente não foi encontrado",
                2, Principal.encontrarNumeroAusenteOrdenando(new int[] {0, 4, 1, 3}));
        Assert.assertEquals("O número ausente não foi encontrado",
                2, Principal.encontrarNumeroAusenteLinear(new int[] {0, 4, 1, 3}));
    }

    @Test
    public void encontrarNumeroAusenteTestParaElementoAusenteExtremo() {
        Assert.assertEquals("O número ausente não foi encontrado",
                0, Principal.encontrarNumeroAusenteOrdenando(new int[] {1, 2, 3, 4}));
        Assert.assertEquals("O número ausente não foi encontrado",
                4, Principal.encontrarNumeroAusenteOrdenando(new int[] {0, 1, 2, 3}));
        Assert.assertEquals("O número ausente não foi encontrado",
                4, Principal.encontrarNumeroAusenteLinear(new int[] {0, 1, 2, 3}));
    }

    @Test
    public void encontrarNumeroAusenteTestParaListaVazia() {
        int[] arrayVazio = new int[] {};
        Assert.assertEquals("O valor retornado deve ser -1 para lista vazia",
                -1, Principal.encontrarNumeroAusente(arrayVazio));
        Assert.assertEquals("O valor retornado deve ser -1 para lista vazia",
                -1, Principal.encontrarNumeroAusenteOrdenando(arrayVazio));
        Assert.assertEquals("O valor retornado deve ser -1 para lista vazia",
                -1, Principal.encontrarNumeroAusenteLinear(arrayVazio));
    }

    @Test
    public void encontrarNumeroAusenteTestParaValoresRepetidos() {
        int[] arrayComRepeticao = new int[] {1, 2, 3, 3, 4};
        Assert.assertEquals("O valor retornado deve ser -1 para lista " +
                "com elementos repetidos",
                -1, Principal.encontrarNumeroAusente(arrayComRepeticao));
        Assert.assertEquals("O valor retornado deve ser -1 para lista " +
                        "com elementos repetidos",
                -1, Principal.encontrarNumeroAusenteOrdenando(arrayComRepeticao));
        Assert.assertEquals("O valor retornado deve ser -1 para lista " +
                        "com elementos repetidos",
                -1, Principal.encontrarNumeroAusenteLinear(arrayComRepeticao));
    }
}