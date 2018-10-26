import exception.DigitacaoIncorretaException;
import exception.SenhaPequenaException;

import java.util.HashMap;
import java.util.Map;

public class Sistema {

    private Map<String, Usuario> usuarioByEmail;

    public Sistema() {
        this.usuarioByEmail = new HashMap<>();
    }

    private Usuario cadastrarUsuario(String email)
            throws SenhaPequenaException,
                   DigitacaoIncorretaException {

        int contTentativas = 0;
        boolean ok = false;
        String senha = null;

        while (!ok && contTentativas < 5) {
            senha = obterSenha();
            String senhaDeNovo = obterSenhaDeNovo();
            if (!senha.equals(senhaDeNovo)) {
                contTentativas++;
                System.out.println("Digite novamente");
                continue;
            }
            ok = true;
        }

        if (!ok) {
            throw new DigitacaoIncorretaException();
        }

        if (senha.length() < 6) {
            throw new SenhaPequenaException();
        }

        String nome = obterNome();
        Usuario novoUsuario = new Usuario(email, nome);
        this.usuarioByEmail.put(email, novoUsuario);
        return novoUsuario;
    }

    private String obterSenha() {
        return "ha";  // ToDo Ler do teclado
    }

    private String obterSenhaDeNovo() {
        return "ha";  // ToDo Ler do teclado
    }

    private String obterNome() {
        return "Fulano de Tal";
    }

    public void iniciarSessao(String email) {
        Usuario usuario = this.usuarioByEmail.get(email);
        if (usuario == null) {
            // usuario nao existe, vamos tentar cadastrar!
            while (true) {
                try {
                    usuario = cadastrarUsuario(email);
                    System.out.println("Usuario cadastrado com sucesso!");
                    break;

                } catch (SenhaPequenaException e) {
                    System.out.println("Senha muito pequena!");
                    continue;  // tentará de novo

                } catch (DigitacaoIncorretaException e) {
                    System.out.println("Voltar para a escola!");
                    break;
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

    public static void main(String[] args) {
        Sistema meuSistema = new Sistema();
        meuSistema.iniciarSessao("homemaranha@teste.com");
    }

}
