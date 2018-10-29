import exception.SenhaPequenaException;
import exception.SenhasNaoCasamException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public class SistemaTest {

    SistemaMock sistema;

    @Before
    public void setUp() {
        sistema = new SistemaMock();
    }

    @Test
    public void testeCadastrarUsuarioFluxoNormal()
            throws SenhasNaoCasamException, SenhaPequenaException {

        sistema.setSenhaASerRetornada1("goiaba");
        sistema.setSenhaASerRetornada2("goiaba");
        sistema.cadastrarUsuario("fulano@teste.com");
    }

    @Test
    public void testeCadastrarUsuarioSenhaMuitoPequena()
            throws SenhasNaoCasamException {

        // mockando o agente externo
        sistema.setSenhaASerRetornada1("go");
        sistema.setSenhaASerRetornada2("go");

        try {
            sistema.cadastrarUsuario("fulano@teste.com");
            fail("Uma SenhaPequenaException deve ser lançada " +
                    "para senhas com menos de 6 caracteres");
        } catch (SenhaPequenaException e) {
            // ok!!!!!!
        }
    }

    @Test
    public void testeCadastrarUsuarioSenhasQueNaoCasam()
            throws SenhaPequenaException {

        // mockando o agente externo
        sistema.setSenhaASerRetornada1("go");
        sistema.setSenhaASerRetornada2("goxxxxx");

        try {
            sistema.cadastrarUsuario("fulano@teste.com");
            fail("Uma SenhasNaoCasamException deve ser lançada " +
                    "para senhas que não casam");
        } catch (SenhasNaoCasamException e) {
            // ok!!!!!!
        }
    }


}