import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListaSequencialTest {

    private Lista<Livro> lista;

    private Livro livro1;
    private Livro livro2;
    private LivroInfantil livro3;

    private final int CAPACIDADE = 200;

    @Before
    public void setUp() {
        lista = new ListaSequencial<>(CAPACIDADE);

        livro1 = new Livro("Livro1");
        livro2 = new Livro("Livro2");
        livro3 = new LivroInfantil("Livro3");

        lista.add(livro1);
        lista.add(livro2);
        lista.add(livro3);
    }

    @Test
    public void testarGetSize() {
        assertEquals("O tamanho deve refletir a quantidade de itens " +
                "que foram adicionados", 3, lista.getSize());
    }

    @Test
    public void testarGet() {
        assertEquals(livro2, lista.get(1));
    }

    @Test
    public void testarRemocao() {
        lista.remove(1);

        assertEquals("O tamanho deve diminuir depois de um remove",
                2, lista.getSize());

        assertEquals(livro3, lista.get(1));
    }

    @Test
    public void testarListaCheia() {
        int x = 1001;
        while (lista.getSize() < CAPACIDADE) {
            lista.add(new Livro("Livro " + x++));
        }
        lista.add(new Livro("Livro Extra"));
    }
}