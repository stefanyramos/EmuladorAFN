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


	public boolean ehAceita2(){
		int q0 = aut.getQ0(); //Estado inicial

		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> queue2 = new LinkedList<>();

		Set<Integer> marked = new HashSet<>();  // set p não repetir simbolo na linha do teste
		queue.add(q0);
		queue.addAll(aut.trLambda(q0));

		System.out.println("q inicial: " + queue.toString());

		int i = 0;

		while(i<cadeia.length){
			System.out.println();
			while(!queue.isEmpty()){
				int s_lido = cadeia[i];
				int q = queue.poll(); 

				System.out.println("q: " + q);
				System.out.println("s: " + s_lido);

				for(Transicao t : aut.trsc(q)){
					int qf = t.getQf(); //estado final 
					int simbolo_t = t.getSimb();
					
					 if((simbolo_t == s_lido) && !marked.contains(qf)){ // se o simbolo lido for igual a da transicao
						System.out.println(t.toString());
						if(i == cadeia.length-1 && (aut.getQa().contains(qf))){ // chegou ao fim da cadeia e está num estado final
							return true;
						}
						else if(i < cadeia.length-1 && !ehFolha(qf, cadeia[i+1])){ // caso cotrario, adiciona na lista de marcados e coloca na fila  
							queue2.add(qf);
							marked.add(qf);
						}
					}
				}

			}
			queue.addAll(queue2);
			queue2.clear();
			System.out.println(queue.toString());
			marked.clear();
			i++;
		}
		return false;

	}



	// verifica se a cadeia é aceita
	public boolean ehAceita(){
		int q0 = aut.getQ0(); //Estado inicial

		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> queue2 = new LinkedList<>();

		Set<Integer> marked = new HashSet<>();  // set p não repetir simbolo na linha do teste
		queue.add(q0);

		int i = -1;

		while(i<cadeia.length-1){
			System.out.println();
			while(!queue.isEmpty()){
				i++;
				int s_lido = cadeia[i];
				int q = queue.poll(); // retira o estado inicial da pilha
									  // e percorre a pilha com os estados "adjacentes"

				System.out.println("q: " + q);
				System.out.println("s: " + s_lido);

				for(Transicao t : aut.trsc(q)){ // percorre a lista ligada de transiçãoes do estado q
					int qf = t.getQf(); //estado final
					int simbolo_t = t.getSimb();
					
					if(i==0 && simbolo_t==0 && s_lido != 0){
						i --;
						queue2.add(q);
						queue2.add(qf);
						//marked.add(qf);
					}
					
					else if((simbolo_t == s_lido) && !marked.contains(qf)){ // se o simbolo lido for igual a da transicao
						System.out.println(t.toString());
						if(i == cadeia.length-1 && (aut.getQa().contains(qf))){ // chegou ao fim da cadeia e está num estado final
							return true;
						}
						else if(i < cadeia.length-1 && !ehFolha(qf, cadeia[i+1])){ // caso cotrario, adiciona na lista de marcados e coloca na fila  
							queue2.add(qf);
							marked.add(qf);
						}
					}

				}
			}
			queue.addAll(queue2);
			queue2.clear();
			System.out.println(queue.toString());
			marked.clear();
			//i++;
		}
		return false;
	}


	// metodo para verificar se o estado é uma folha 
	private boolean ehFolha(int qi,int simb){
		for(Transicao t : aut.trsc(qi))
			if(t.getSimb() == simb)
				return false;
		return true;
	}


}

