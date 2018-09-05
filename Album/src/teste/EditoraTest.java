package teste;

import dominio.Album;
import dominio.Editora;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EditoraTest {

    private Editora editora;
    private Album album;
    private int nFigurinhas = 10;
    private int figurinhasPorPacote = 2;

    @Before
    public void setUp() throws Exception {
        editora = new Editora(figurinhasPorPacote, nFigurinhas);
        album = new Album(nFigurinhas);
    }

    @Test
    public void adquirirPacotinhoAleatorioTest() {
        for (int i = 0; i < 1000; i++) {
            // vamos testar várias vezes, por conta da aleatoriedade
            int[] pacotinho = editora.adquirirPacotinhoAleatorio();
            assertEquals("O pacotinho retornado deve ter o tamanho especificado",
                    figurinhasPorPacote, pacotinho.length);
            for (int figurinha : pacotinho) {
                assertTrue("Cada figurinha do pacotinho deve estar no range " +
                                "de 1 a " + nFigurinhas,
                        figurinha >= 1 && figurinha <= nFigurinhas);
            }
        }
    }

    @Test
    public void adquirirFigurinhaTest() {

    }
}