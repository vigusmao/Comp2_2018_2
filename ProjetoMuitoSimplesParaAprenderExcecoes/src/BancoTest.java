import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class BancoTest {

    @Test
    public void depositarFluxoNormal() {
        Banco banco = new Banco();
        try {
            banco.depositar(1234, 50);
        } catch (ValorInvalidoException | ContaInexistenteException e) {
            fail("O depósito deve ser bem sucedido para contas e valores válidos.");
        }
    }

    @Test
    public void depositarEmContaInexiste() {
        Banco banco = new Banco();
        try {
            banco.depositar(-1234, 50);
            fail("Devemos proibir depósitos em contas inexistentes!!!!");

        } catch (ContaInexistenteException e) {
            // Ok! É aqui mesmo que queremos entrar!!
            assertEquals(1, e.getContOcorrencias());

        } catch (ValorInvalidoException e) {
            fail("O depósito deve ser bem sucedido para valores válidos.");
        }

        // Agora faremos um segundo depósito em conta inexistente

        try {
            banco.depositar(-1234, 50);
            fail("Devemos proibir depósitos em contas inexistentes!!!!");

        } catch (ContaInexistenteException e) {
            // Ok! É aqui mesmo que queremos entrar!!
            assertEquals(2, e.getContOcorrencias());
        } catch (ValorInvalidoException e) {
            fail("O depósito deve ser bem sucedido para valores válidos.");
        }

    }

}