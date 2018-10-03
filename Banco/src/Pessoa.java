import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Pessoa {

   private List<Conta> contas;
   private Map<Long, Conta> contaByNumero;

   public abstract long getId();

   public Pessoa() {
       this.contas = new ArrayList<>();
       this.contaByNumero = new HashMap<>();
   }

   void addConta(Conta conta) {
       if (!conta.getDono().equals(this)) {
           System.out.println("A conta tem outro dono! " +
                   "Não vou adicionar!");
           return;
       }
       this.contas.add(conta);
       this.contaByNumero.put(
               conta.getNumeroDaConta(), conta);

   }

   public Conta getConta(long numeroDaConta) {
//       for (int i = 0; i < this.contas.size(); i++) {
//           Conta conta = this.contas.get(i);
//           if (conta.getNumeroDaConta() == numeroDaConta) {
//               return conta;
//           }
//       }
//       for (Conta conta : this.contas) {
//           if (conta.getNumeroDaConta() == numeroDaConta) {
//               return conta;
//           }
//       }
       return this.contaByNumero.get(numeroDaConta);
   }
}
