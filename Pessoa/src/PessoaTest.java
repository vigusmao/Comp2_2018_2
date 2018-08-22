import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PessoaTest {

    private Pessoa pessoa;

    @Before
    public void setUp() {
        pessoa = new Pessoa("Fulano de Tal", 1998);
        pessoa.setCpf(1234);
    }

    @Test
    public void getIdadeTest() {
        assertEquals(20, pessoa.getIdade());
    }

    @Test
    public void getNomeTest() {
        assertEquals("Fulano de Tal", pessoa.getNome());
    }

    @Test
    public void getCpfTest() {
        assertEquals(1234, pessoa.getCpf());
        pessoa.setCpf(4567);
        assertEquals(4567, pessoa.getCpf());
    }
}