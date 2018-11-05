import java.util.Scanner;

public class SistemaBancario {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Banco meuBanco = new Banco();

        // ...

        while (true) {
            long numeroDaConta = perguntarNumeroDaConta();
            int valor = perguntarValor();

            try {
                System.out.println("Abrindo arquivo de transacoes...");

                meuBanco.depositar(numeroDaConta, valor);
                System.out.println("Depósito efetuado com sucesso!!!");
                break;

            } catch (ValorInvalidoException | ContaInexistenteException e) {
                System.out.println(e.getMessage());

            } catch (Exception e) {
                System.out.println("Exceção genérica aconteceu. Tente mais tarde.");

            } finally {
                fecharArquivoTransacoes();
            }
        }
    }

    private static void fecharArquivoTransacoes() {
        System.out.println("Fechei o arquivo");
    }

    private static int perguntarValor() {
        return sc.nextInt();
    }

    private static long perguntarNumeroDaConta() {
        return sc.nextLong();
    }
}
