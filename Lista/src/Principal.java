public class Principal {

    public static void main(String[] args) {
        ListaSequencial<Livro> minhaLista;
        minhaLista = new ListaSequencial<>(1000);

        for (int i = 0; i < 1000; i++) {
            minhaLista.add(new Livro(""));
        }

        System.out.println("Total de escritas = " +
            minhaLista.getTotalDeEscritas());
    }
}
