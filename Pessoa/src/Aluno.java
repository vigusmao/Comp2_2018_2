public class Aluno extends Pessoa {

    private Conceito[] conceitos;
    private int conceitosDigitados;
    private final long dre;
    private float cra;

    public Aluno(String nome, int anoDeNascimento, long dre) {
        super(nome, anoDeNascimento);
        this.dre = dre;
        this.conceitos = new Conceito[100];
        this.conceitosDigitados = 0;
    }

    /**
     * Inclui um novo conceito no histórico do aluno para o ano corrente.
     * @param disciplina a disciplina desejada
     * @param nota a nota
     * @param semestre o semestre (do ano corrente!!) desejado
     * @param quantCreditos a quantidade de créditos obtidos nessa disciplina
     */
    public void incluirConceito(String disciplina, float nota,
                                int semestre, int quantCreditos) {
        Conceito novoConceito = new Conceito();
        novoConceito.disciplina = disciplina;
        novoConceito.nota = nota;
        novoConceito.ano = Utils.getAnoCorrente();
        novoConceito.semestre = semestre;
        novoConceito.quantCreditos = quantCreditos;
        this.conceitos[this.conceitosDigitados++] = novoConceito;
        atualizarCRA();
    }

    private void atualizarCRA() {
        float totalNotas = 0;
        for (Conceito conceito : this.conceitos) {
            if (conceito == null) {
                break;
            }
            totalNotas += conceito.nota;
        }
        this.cra = totalNotas / this.conceitosDigitados;
    }

    public String getHistorico() {
        StringBuilder sbHistorico = new StringBuilder();
        sbHistorico.append("Aluno: ")
                .append(this.nome);
        for (Conceito conceito : this.conceitos) {
            if (conceito == null) {
                break;
            }
            sbHistorico.append("\n").append(conceito.toString());
        }
        return sbHistorico.toString();
    }

    public float getCRA() {
        return this.cra;
    }

    private class Conceito {
        String disciplina;
        float nota;
        int ano;
        int semestre;
        int quantCreditos;

        @Override
        public String toString() {
            return String.format("disciplina: %s -- período: %d/%d -- nota: %.1f",
                    disciplina, ano, semestre, nota);
        }
    }
}
