import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CalculadoraMedias {

    private static float calcularMediaDaTurma(String nomeDoArquivo)
            throws FileNotFoundException {

        File f = new File(nomeDoArquivo);;
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

                } catch (NumberFormatException e) {

                }
            }

            if (quantLinhasInvalidas > quantNotas) {
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
        String nomeArquivo = lerNomeArquivoDoTeclado();
        float media = calcularMediaDaTurma(nomeArquivo);
        System.out.printf("Media = %.2f\n", media);
    }
}
