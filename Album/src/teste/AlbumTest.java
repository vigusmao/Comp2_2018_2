package teste;

import dominio.Album;
import dominio.Figurinha;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlbumTest {

    private Album album;
    private int tamanho = 100;

    private int inicioSequencia = 10;
    private int fimSequencia = 19;
    private Figurinha figurinhaMuitoRepetida;

    @Before
    public void setUp() throws Exception {
        album = new Album(tamanho);
        figurinhaMuitoRepetida = new Figurinha(11);
    }

    @Test
    public void testePreenchimento() {
        assertEquals("O álbum precisa estar vazio inicialmente",
                0, album.getContadorItems());

        Figurinha novaFig = new Figurinha(15);
        album.receberItem(novaFig);

        assertTrue("O álbum deve conter figurinhas que foram recebidas",
                album.possuiItem(15));
        assertEquals("O álbum não deve considerar como repetida a primeira " +
                "figurinha recebida de cada posição",
                0, album.getContadorRepetidos(15));

        assertEquals("O total de figurinhas deve refletir a quantidade de figurinhas " +
                        "distintas já recebidas",
                1, album.getContadorItems());

        Figurinha outraFig = new Figurinha(16);
        album.receberItem(outraFig);

        assertEquals("O total de figurinhas deve refletir a quantidade de figurinhas " +
                        "distintas já recebidas",
                2, album.getContadorItems());

        Figurinha figRepetida = new Figurinha(15);
        album.receberItem(figRepetida);

        assertEquals("O total de figurinhas deve refletir a quantidade de figurinhas " +
                        "distintas já recebidas",
                2, album.getContadorItems());

        assertEquals("O álbum deve computar corretamente o total de repetidas",
                1, album.getContadorRepetidos(15));
    }

    @Test
    public void isCheioTest() {
        assertFalse("O álbum inicialmente não está cheio", album.isCheio());

        for (int i = 1; i < tamanho; i++) {
            Figurinha fig = new Figurinha(i, "urlDaImagemI");
            album.receberItem(fig);
        }
        assertFalse("O álbum não está cheio se ainda faltam figurinhas",
                album.isCheio());

        Figurinha fig = new Figurinha(tamanho, "urlQualquer");
        album.receberItem(fig);
        assertTrue("O álbum precisa retornar que está cheio quando possuir " +
                "todas as figurinhas",
                album.isCheio());
    }

    @Test
    public void trocarFigurinhaTestParaSituacaoNormal() {
        preencherAlbumComAlgumasFigurinhas();

        int quantInicialFigurinhas = album.getContadorItems();
        int quantInicialRepetidas = album.getContadorRepetidos();

        Figurinha figurinhaInedita = new Figurinha(
                fimSequencia + 1);
        album.trocarItem(figurinhaInedita, figurinhaMuitoRepetida);

        assertEquals("Quando trocamos uma figurinha repetida por uma que é inédita, " +
                "o álbum deve acrescentá-la normalmente",
                quantInicialFigurinhas + 1, album.getContadorItems());
        assertEquals("Quando trocamos uma figurinha repetida, o total de repetidas deve " +
                "ser decrementado",
                quantInicialRepetidas - 1, album.getContadorRepetidos());
        assertTrue("A figurinha recebida na troca deve ser incluída no álbum",
                album.possuiItem(figurinhaInedita.getPosicao()));
    }

    @Test
    public void trocarFigurinhaTestParaSituacaoDeReceberFigurinhaQueJaPossui() {
        preencherAlbumComAlgumasFigurinhas();

        int quantInicialFigurinhas = album.getContadorItems();
        int quantInicialRepetidas = album.getContadorRepetidos();

        Figurinha figurinhaPoucoRepetida = new Figurinha(inicioSequencia);
        int quantInicialRepetidasDaFigurinhaQueSeraDada = album.getContadorRepetidos(
                figurinhaMuitoRepetida.getPosicao());
        int quantInicialRepetidasDaFigurinhaQueSeraRecebida = album.getContadorRepetidos(
                figurinhaPoucoRepetida.getPosicao());
        album.trocarItem(figurinhaPoucoRepetida, figurinhaMuitoRepetida);

        assertEquals(quantInicialFigurinhas, album.getContadorItems());
        assertEquals(quantInicialRepetidas, album.getContadorRepetidos());

        assertEquals(quantInicialRepetidasDaFigurinhaQueSeraDada - 1,
                album.getContadorRepetidos(figurinhaMuitoRepetida.getPosicao()));
        assertEquals(quantInicialRepetidasDaFigurinhaQueSeraRecebida + 1,
                album.getContadorRepetidos(figurinhaPoucoRepetida.getPosicao()));
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
            Figurinha fig = new Figurinha(i);
            album.receberItem(fig);
        }
        album.receberItem(figurinhaMuitoRepetida);
        album.receberItem(figurinhaMuitoRepetida);
        album.receberItem(figurinhaMuitoRepetida);
    }
}