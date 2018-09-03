package teste;

import dominio.Album;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlbumTest {

    private Album album;
    private int tamanho = 100;

    private int inicioSequencia = 10;
    private int fimSequencia = 19;
    private int figurinhaMuitoRepetida = 11;

    @Before
    public void setUp() throws Exception {
        album = new Album(tamanho);
    }

    @Test
    public void testePreenchimento() {
        assertEquals("O álbum precisa estar vazio inicialmente",
                0, album.getContadorFigurinhas());

        album.receberFigurinha(15);

        assertTrue("O álbum deve conter figurinhas que foram recebidas",
                album.possuiFigurinha(15));
        assertEquals("O álbum não deve considerar como repetida a primeira " +
                "figurinha recebida de cada posição",
                0, album.getContadorRepetidas(15));

        assertEquals("O total de figurinhas deve refletir a quantidade de figurinhas " +
                        "distintas já recebidas",
                1, album.getContadorFigurinhas());

        album.receberFigurinha(16);

        assertEquals("O total de figurinhas deve refletir a quantidade de figurinhas " +
                        "distintas já recebidas",
                2, album.getContadorFigurinhas());

        album.receberFigurinha(15);

        assertEquals("O total de figurinhas deve refletir a quantidade de figurinhas " +
                        "distintas já recebidas",
                2, album.getContadorFigurinhas());

        assertEquals("O álbum deve computar corretamente o total de repetidas",
                1, album.getContadorRepetidas(15));
    }

    @Test
    public void isCheioTest() {
        assertFalse("O álbum inicialmente não está cheio", album.isCheio());

        for (int i = 1; i < tamanho; i++) {
            album.receberFigurinha(i);
        }
        assertFalse("O álbum não está cheio se ainda faltam figurinhas",
                album.isCheio());


        album.receberFigurinha(tamanho);
        assertTrue("O álbum precisa retornar que está cheio quando possuir " +
                "todas as figurinhas",
                album.isCheio());
    }

    @Test
    public void trocarFigurinhaTestParaSituacaoNormal() {
        preencherAlbumComAlgumasFigurinhas();

        int quantInicialFigurinhas = album.getContadorFigurinhas();
        int quantInicialRepetidas = album.getContadorRepetidas();

        int figurinhaInedita = fimSequencia + 1;
        album.trocarFigurinha(figurinhaInedita, figurinhaMuitoRepetida);

        assertEquals("Quando trocamos uma figurinha repetida por uma que é inédita, " +
                "o álbum deve acrescentá-la normalmente",
                quantInicialFigurinhas + 1, album.getContadorFigurinhas());
        assertEquals("Quando trocamos uma figurinha repetida, o total de repetidas deve " +
                "ser decrementado",
                quantInicialRepetidas - 1, album.getContadorRepetidas());
        assertTrue("A figurinha recebida na troca deve ser incluída no álbum",
                album.possuiFigurinha(figurinhaInedita));
    }

    @Test
    public void trocarFigurinhaTestParaSituacaoDeReceberFigurinhaQueJaPossui() {
        preencherAlbumComAlgumasFigurinhas();

        int quantInicialFigurinhas = album.getContadorFigurinhas();
        int quantInicialRepetidas = album.getContadorRepetidas();

        int figurinhaPoucoRepetida = inicioSequencia;
        int quantInicialRepetidasDaFigurinhaQueSeraDada = album.getContadorRepetidas(
                figurinhaMuitoRepetida);
        int quantInicialRepetidasDaFigurinhaQueSeraRecebida = album.getContadorRepetidas(
                figurinhaPoucoRepetida);
        album.trocarFigurinha(figurinhaPoucoRepetida, figurinhaMuitoRepetida);

        assertEquals(quantInicialFigurinhas, album.getContadorFigurinhas());
        assertEquals(quantInicialRepetidas, album.getContadorRepetidas());

        assertEquals(quantInicialRepetidasDaFigurinhaQueSeraDada - 1,
                album.getContadorRepetidas(figurinhaMuitoRepetida));
        assertEquals(quantInicialRepetidasDaFigurinhaQueSeraRecebida + 1,
                album.getContadorRepetidas(figurinhaPoucoRepetida));
    }

    @Test
    public void getContadorFigurinhas() {
    }

    @Test
    public void getContadorRepetidas() {
    }

    @Test
    public void getContadorRepetidas1() {
    }

    @Test
    public void isFinalizacaoPreenchimentoPossivel() {
    }

    /** O álbum será preenchido com todas as figurinhas entre this.inicioSequencia e
        this.fimSequencia, contendo também algumas repetidas de this.figurinhaMuitoRepetida
     */
    private void preencherAlbumComAlgumasFigurinhas() {
        for (int i = inicioSequencia; i <= fimSequencia; i++) {
            album.receberFigurinha(i);
        }
        album.receberFigurinha(figurinhaMuitoRepetida);
        album.receberFigurinha(figurinhaMuitoRepetida);
        album.receberFigurinha(figurinhaMuitoRepetida);
    }
}