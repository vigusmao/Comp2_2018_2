import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CalculadoraMedias {

    private static float calcularMediaDaTurma(String nomeDoArquivo)
            throws FileNotFoundException, ArquivoCorrompidoException {

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
                throw new ArquivoCorrompidoException(quantLinhasInvalidas);
            }

            return soma / quantNotas;

        } finally {
            sc.close();
        }
    }



    public static void main(String[] args) {
        while (true) {
            // ToDo criar o método que lê do teclado o nome do arquivo
            String nomeArquivo = lerNomeArquivoDoTeclado();

            try {
                float media = calcularMediaDaTurma(nomeArquivo);
                // ToDo imprime a media
                break;

            } catch (FileNotFoundException e) {
                // ToDo diz para o usuário digitar novamente

            } catch (ArquivoCorrompidoException e) {
                int quantInvalidas = e.getQuantLinhasInvalidas();
                // ToDo imprime quantidade de linhas inválidas
                break;
            }
        }
    }
}
