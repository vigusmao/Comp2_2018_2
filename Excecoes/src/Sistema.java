import exception.SenhaPequenaException;
import exception.SenhasNaoCasamException;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sistema {

    private Map<String, Usuario> usuarioByEmail;
    private Scanner scanner;

    public Sistema() {
        this.usuarioByEmail = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Cadastra um novo usuário.
     *
     * @param email O email do novo usuário a ser cadastrado
     * @return O objeto Usuario que foi criado neste cadastro
     *
     * @throws SenhaPequenaException se a senha digitada tiver menos
     *                               do que 6 caracteres
     * @throws SenhasNaoCasamException se as duas senhas digitadas divergirem
     */
    Usuario cadastrarUsuario(String email)
            throws SenhaPequenaException,
                   SenhasNaoCasamException {

        String senha = obterSenha();
        String senhaDeNovo = obterSenhaDeNovo();
        if (!senha.equals(senhaDeNovo)) {
            throw new SenhasNaoCasamException();
        }

        if (senha.length() < 6) {
            throw new SenhaPequenaException();
        }

        String nome = obterNome();
        Usuario novoUsuario = new Usuario(email, nome);
        this.usuarioByEmail.put(email, novoUsuario);
        return novoUsuario;
    }

    String obterSenha() {
        return scanner.nextLine();
    }

    String obterSenhaDeNovo() {
        return scanner.nextLine();
    }

    private String obterNome() {
        return "Fulano de Tal";
    }

    public void iniciarSessao(String email) {
        Usuario usuario = this.usuarioByEmail.get(email);
        if (usuario == null) {
            // usuario nao existe, vamos tentar cadastrar!
            int contTentativas = 0;
            while (contTentativas < 5) {
                try {
                    System.out.println("Abrindo o arquivo de usuários...");

                    usuario = cadastrarUsuario(email);
                    System.out.println("Usuario cadastrado com sucesso!");
                    break;

                } catch (SenhaPequenaException e) {
                    System.out.println("Senha muito pequena!");
                    continue;  // tentará de novo

                } catch (SenhasNaoCasamException e) {
                    System.out.println("Senhas não casam.");
                    System.out.println("Tente novamente.");
                    contTentativas++;

                } finally {
                    System.out.println("Fechando o arquivo de usuários...");
                }
            }
        }

        if (usuario != null) {
            System.out.println(
                    String.format("Bom dia, %s!!!",
                            usuario.getNome()));
        } else {
            System.out.println("Mau dia!");
        }
    }

    private Usuario getUsuario(String email) {
        return this.usuarioByEmail.get(email);
    }

    /**
     * Se o usuário existir, retorna seu nome; caso contrário, retorna nulo.
     *
     * @param email
     * @return
     */
    public String getNomeUsuario(String email) {
        Usuario usuario = getUsuario(email);
        return usuario == null ? null : usuario.getNome();
    }

    public static void main(String[] args) {
        Sistema meuSistema = new Sistema();
        meuSistema.iniciarSessao("homemaranha@teste.com");

        System.out.println(
                meuSistema.getNomeUsuario("xxxcxxxxx@teste.com"));
    }
}
