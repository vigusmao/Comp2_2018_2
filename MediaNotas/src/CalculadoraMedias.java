import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CalculadoraMedias {

    private static float calcularMediaDaTurma(String nomeDoArquivo)
            throws FileNotFoundException {

        File f = new File(nomeDoArquivo);
        Scanner sc = null;

        try {
            sc = new Scanner(f);

            float soma = 0;
            int quantNotas = 0;
            int quantLinhasInvalidas = 0;

            while (sc.hasNext()) {
                String linha = sc.nextLine();
                try {
                    float nota = Float.parseFloat(linha);

                    // ToDo processar nota lida

                } catch (NumberFormatException e) {

                    // ToDo incrementar contador de inválidas
                }
            }

            if (quantLinhasInvalidas > quantNotas) {
                // ToDo criar a classe da exceção abaixo
                throw new ArquivoCorrompidoException(
                        String.format("O arquivo tem " +
                            "%d linhas inválidas", quantLinhasInvalidas));
            }

            return soma / quantNotas;

        } finally {
            sc.close();
        }
    }



    public static void main(String[] args) {

        // ToDo envolver as próximas duas linhas num loop
        // ToDo criar o método que lê do teclado o nome do arquivo
        String nomeArquivo = lerNomeArquivoDoTeclado();
        float media = calcularMediaDaTurma(nomeArquivo);
        // ToDo capturar FileNotFoundException e se manter no loop
        // ToDo sair do loop por uma ArquivoCorrompidoException
        // ToDo sair do loop se a média foi obtida corretamente

        System.out.printf("Media = %.2f\n", media);
        // ToDo se houve ArquivoCorrompidoException, mostrar msg
    }
}
