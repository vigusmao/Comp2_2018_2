import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReceitaFederal {

//    private List<Pessoa> contribuintes;

    private Map<Long, Pessoa> contribuinteByCpf;

    public ReceitaFederal() {
//        this.contribuintes = new ArrayList<>();
        this.contribuinteByCpf = new HashMap<>();
    }

    public void addContribuinte(Pessoa contribuinte) {
//        this.contribuintes.add(contribuinte);
        this.contribuinteByCpf.put(contribuinte.getCpf(), contribuinte);
    }

    public String getNome(long cpf) {
//        for (int i = 0; i < this.contribuintes.size(); i++) {
//            Pessoa p = this.contribuintes.get(i);
//            if (p.getCpf() == cpf) {
//                return p.getNome();
//            }
//        }
//        return null;
        Pessoa p = this.contribuinteByCpf.get(cpf);
        if (p != null) {
            return p.getNome();
        }
        return null;
    }
}
