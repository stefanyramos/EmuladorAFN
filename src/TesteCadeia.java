import java.util.*;

public class TesteCadeia{
	private Automato aut;
	private Transicao[] edgeTo;
	private int[] cadeia; 

	public TesteCadeia(Automato aut, int[] cadeia){
		this.aut = aut;
		this.cadeia = cadeia;
		this.cadeia = cadeia;

	}

	public boolean ehAceita(){
		int q0 = aut.getQ0(); //Estado inicial

		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> marked = new HashSet<>();  // pilha p não repetir simbolo na linha do teste
		queue.add(q0);

		int p = 0;

		while(!queue.isEmpty() && p<cadeia.length){
			int s_lido = cadeia[p];
			System.out.println("\nsimbolo: " + s_lido);
			int q = queue.poll(); // retira o estado inicial da pilha

			System.out.println("q: " + q);
								  // e percorre a pilha com os estados "adjacentes"
			for(Transicao t : aut.trsc(q)){ // percorre a lista ligada de transiçãoes do estado q
				int qf = t.getQf(); //estado final
				int simbolo_t = t.getSimb();
				
				
				if((simbolo_t == s_lido) && !marked.contains(qf)){
					//marked.add(qf);
					System.out.println("t " + t.toString());
					if(p == cadeia.length-1 && (aut.getQa().contains(qf))){
						return true;
					}
					if(p != cadeia.length-1){
						queue.add(qf);
						marked.add(qf);
					}
					System.out.println("queue: = " + queue.toString());

				}
			}
			p++;
			marked.clear(); // reseta a pilha p cada simbolo lido
		}
		
		return false;

	}


	private boolean ehFolha(int qi,int simb){
		for(Transicao t : aut.trsc(qi))
			if(t.getSimb() == simb)
				return false;
		return true;
	}


}

