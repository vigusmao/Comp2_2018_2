import org.junit.Assert;
import org.junit.Test;

public class PrincipalTest {

    @Test
    public void encontrarNumeroAusenteTest() {
/*        int[] arrayDeTeste = new int[4];
          arrayDeTeste[0] = 0;
          arrayDeTeste[1] = 4;
          arrayDeTeste[2] = 1;
          arrayDeTeste[3] = 3;
*/
        // A linha seguinte é equivalente ao bloco comentado acima.
        int[] arrayDeTeste = new int[] {0, 4, 1, 3};

        Assert.assertEquals("O número ausente não foi encontrado",
                2, Principal.encontrarNumeroAusente(arrayDeTeste));
    }

    @Test
    public void encontrarNumeroAusenteTestParaListaVazia() {
        int[] arrayVazio = new int[] {};
        Assert.assertEquals("O valor retornado deve ser -1 para lista vazia",
                -1, Principal.encontrarNumeroAusente(arrayVazio));
    }

    @Test
    public void encontrarNumeroAusenteTestParaValoresRepetidos() {
        int[] arrayComRepeticao = new int[] {1, 2, 3, 3, 4};
        Assert.assertEquals("O valor retornado deve ser -1 para lista " +
                "com elementos repetidos",
                -1, Principal.encontrarNumeroAusente(arrayComRepeticao));
    }
}