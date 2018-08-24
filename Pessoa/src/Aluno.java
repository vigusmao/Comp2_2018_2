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

    public void incluirConceito(String disciplina, float nota,
                                int semestre) {
        Conceito novoConceito = new Conceito();
        novoConceito.disciplina = disciplina;
        novoConceito.nota = nota;
        novoConceito.ano = Utils.getAnoCorrente();
        novoConceito.semestre = semestre;
        this.conceitos[this.conceitosDigitados++] = novoConceito;
    }

    public String getHistorico() {
        String historico = "Aluno: " + this.nome;
        for (Conceito conceito : this.conceitos) {
            if (conceito == null) {
                break;
            }
            historico = historico + "\n" + conceito.toString();
        }
        return historico;
    }

    private class Conceito {
        String disciplina;
        float nota;
        int ano;
        int semestre;

        @Override
        public String toString() {
            return String.format("disciplina: %s -- período: %d/%d -- nota: %.1f",
                    disciplina, ano, semestre, nota);
        }
    }
}
