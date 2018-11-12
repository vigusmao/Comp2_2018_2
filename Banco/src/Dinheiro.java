public enum Dinheiro {

    MOEDA_DE_CINCO_CENTAVOS(0.05f, "moeda de cinco"),
    MOEDA_DE_DEZ_CENTAVOS(0.10f, "moeda de dez"),
    MOEDA_DE_VINTE_E_CINCO_CENTAVOS(0.25f),
    MOEDA_DE_CINQUENTA_CENTAVOS(0.50f),
    MOEDA_DE_UM_REAL(1),
    NOTA_DE_UM_REAL(1),
    NOTA_DE_DOIS_REAIS(2),
    NOTA_DE_CINCO_REAIS(5),
    NOTA_DE_DEZ_REAIS(10, "dezão"),
    NOTA_DE_VINTE_REAIS(20),
    NOTA_DE_CINQUENTA_REAIS(50),
    NOTA_DE_CEM_REAIS(100);

    private final float valorEmReais;
    private final String apelido;

    private Dinheiro(float valor) {
        this(valor, "");
    }

    private Dinheiro(float valor, String apelido) {
        this.valorEmReais = valor;
        this.apelido = apelido;
    }

    public float getValorEmReais() {
        return this.valorEmReais;
    }

    public String getApelido() {
        return this.apelido;
    }

    public static boolean verificarValor(float valor) {
        for (Dinheiro dinheiro : Dinheiro.values()) {
            if (dinheiro.getValorEmReais() == valor) {
                return true;
            }
        }
        return false;
    }


//    NÃO FAÇA COMO ESTÁ ABAIXO! NÃO É NECESSÁRIO!!!!!
//
//    public static float getValor(Dinheiro dinheiro) {
//        switch (dinheiro) {
//            case MOEDA_DE_CINCO_CENTAVOS:
//                return 0.05f;
//            case MOEDA_DE_DEZ_CENTAVOS:
//                return 0.10f;
//            //...
//            case NOTA_DE_CEM_REAIS:
//                return 100;
//        }
//        return 0;
//    }
}
