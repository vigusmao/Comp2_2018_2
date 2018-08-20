public class MatematicaBasica {


    public static void main(String[] args) {

        Fracao minhaFracao = new Fracao(-3, 7);
        System.out.print("Minha fração é ");
        System.out.println(minhaFracao);

        Fracao outraFracao = new Fracao(-6, 14);
        System.out.print("A outra fração é ");
        System.out.println(outraFracao);

        System.out.println("minhaFracao == outraFracao --> " +
                (minhaFracao == outraFracao));
        System.out.println("minhaFracao.equals(outraFracao) --> " +
                (minhaFracao.equals(outraFracao)));
    }

}
