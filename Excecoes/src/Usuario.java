public class Usuario {

    private final String email;
    private String nome;
    private int pontos;
    private String senha;

    public Usuario(String email, String nome) {
        this.email = email;
        this.nome = nome;
        this.pontos = 1000;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
