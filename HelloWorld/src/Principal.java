import java.util.Scanner;

public class Principal {

    /**
     * Método bobinho que soma dois inteiros.
     *
     * @param x um inteiro
     * @param y outro inteiro
     * @return a soma dos inteiros informados
     */
    public static int soma(int x, int y) {
        // Tipos primitivos: int, long, float, double, char, boolean...
        return x + y;
    }

    /**
     * JavaDoc do método facaAlgoParecidoComC(). Nunca deixe de "javadocar" seus métodos públicos.
     * Aqui não fazemos nada muito interessante. Estamos apenas brincando com a sintaxe parecida com C.
     */
    public static void facaAlgoParecidoComC() {
        /* em C:   int numeros[30];  // alocação estática
                 ou
                   int *numeros = (int*) malloc(30*sizeof(int));  // alocação dinâmica
        */

        int[] numeros = new int[30];  // arrays são 0-based e criados dessa forma em Java

        for(int i = 0; i <= 1000; i++) {

            if(i == 12) {
                continue;  // vai direto para a próxima iteração
            }

            if(i == 15) {
                break;  // sai completamente do loop
            }

            if(i<5 && i%2 == 0) {  // operadores lógicos/numéricos como em C: &&, ||, ==, <, >, <=, >=, != ...
                numeros[i] = i+100;
            } else {
                numeros[i] = i*i;
            }

            // também poderia ter escrito dessa forma:
            numeros[i] = (i<5 && i%2 == 0) ? i+100 : i*i;
            // o operador ternario é idêntico ao C
        }

        boolean test;
        test = numeros[1] < numeros[5];  // um booleano "de verdade"

        System.out.println(soma(numeros[3], numeros[5]));

        int x = numeros[3];

        switch(x) {
            case 9:
                System.out.println("Oi!");
                break;

            case 11:
                System.out.println("Tchau!");
                break;

            default:
                System.out.println(test ? "Sei lá!" : "Muito estranho");
        }
    }

    /**
     * Imprime os divisores do número informado.
     *
     * @param numero O numero cujos divisores vamos listar.
     */
    public static void imprimirDivisores(int numero) {

        for(int i=1; i <= numero; i++) {
            if(numero % i == 0) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Hello world!!!!");
        imprimirDivisores(10);
        facaAlgoParecidoComC();

        Scanner scanner = new Scanner(System.in);  // declarando um scanner (leitor) para o teclado
        String linha = scanner.nextLine();  // lendo a próxima linha digitada

        System.out.println(String.format("%s possui %d caracteres", linha, linha.length()));
        /* A linha abaixo terá exatamente o mesmo efeito, usando printf
           (note que não precisamos do String.format() para passar parâmetros posicionais, e
           note também o \n no final). */
        System.out.printf("%s possui %d caracteres\n", linha, linha.length());

        System.out.println("Fim!");
    }
}
