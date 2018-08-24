import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AlunoTest {

    private Aluno aluno;
    private static final float DELTA = 0.00000001f;

    @Before
    public void setUp() throws Exception {
        this.aluno = new Aluno("Fulano de Tal", 1999, 12345);
    }

    @Test
    public void incluirConceitoTest() {
//        assertTrue(Math.abs(aluno.getCRA() - 0) < DELTA);

        // Melhor...
        assertEquals("O CRA inicial deve ser zero!", 0, aluno.getCRA(), DELTA);
        this.aluno.incluirConceito("Comp1", 8, 1, 6);
        assertEquals("O CRA deve ser atualizado quando um novo conceito é lançado!", 8f, aluno.getCRA(), DELTA);
        this.aluno.incluirConceito("MatComb", 3, 1, 4);
        assertEquals("O CRA deve ser a média de todos os conceitos " +
                "(usando os créditos como peso)", 6f, aluno.getCRA(), DELTA);
    }

    @Test
    public void imprimirHistoricoTest() {
        this.aluno.incluirConceito("Comp1", 8, 1, 6);
        this.aluno.incluirConceito("Calculo1", 2.5f, 1, 6);
        int anoCorrente = Utils.getAnoCorrente();
        String historicoEsperado = String.format("Aluno: Fulano de Tal\n" +
                "disciplina: Comp1 -- período: %d/1 -- nota: 8,0\n" +
                "disciplina: Calculo1 -- período: %d/1 -- nota: 2,5",
                anoCorrente, anoCorrente);
        assertEquals(historicoEsperado, this.aluno.getHistorico());
    }
}