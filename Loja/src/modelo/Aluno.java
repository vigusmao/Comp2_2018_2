package modelo;

import static modelo.TipoDeAluno.ENSINOMEDIO;

public class Aluno extends Pessoa {

    public static final int GRADUACAO = 1;
    public static final int POSGRADUACAO = 2;

    private long dre;

    private float cra;

    private TipoDeAluno categoria;

    public Aluno(String nome, int anoNascimento, long dre) {
        super(nome, anoNascimento);
        this.dre = dre;
    }

    public void estudar() {
        System.out.println("Estou estudando...");
    }

    public void setTipo(TipoDeAluno tipo) {
        this.categoria = tipo;
    }

    public TipoDeAluno getTipo() {
        return categoria;
    }

    public float getCra() {
        return cra;
    }

    public void setCra(float cra) {
        this.cra = cra;
    }

    @Override
    public void entregar(Vendavel item, String endereco) {
        System.out.printf("Sou o %s e estou levando DESESPERADAMENTE (porque tenho que estudar!!!!)" +
                        " o item %s para o endereço %s...\n",
                this.nome, item.getDescricao(), endereco);
    }

    private String getConceito() {
        if (cra >= 9.0f) {
            return "A";
        } else if (cra >= 7.0f) {
            return "B";
        } else if (cra >= 5.0) {
            return "C";
        } else {
            return "D";
        }
    }

    @Override
    public String toString() {
        String result = null;

        if (categoria.equals(GRADUACAO)) {
            result = String.format("%s : aluno de graduação -- CRA: %.2f",
                    nome, cra);
        } else if (categoria.equals(POSGRADUACAO)) {
            result = String.format("%s : aluno de pós-graduação -- conceito: %s",
                    nome, getConceito());
        }
        return result;
    }

    public static void main(String[] args) {
        Aluno aluno = new Aluno("Fulano", 2000, 1234L);
        aluno.setTipo(ENSINOMEDIO);
        aluno.setCra(6.5f);
        System.out.println(aluno);
    }
}
