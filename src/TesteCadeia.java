import java.util.*;

public class TesteCadeia{
	// classe responsável por testar uma cadeia dado um autonomo
	private Automato aut;
	private Transicao[] edgeTo;
	private int[] cadeia; 

	public TesteCadeia(Automato aut, int[] cadeia){
		this.aut = aut;
		this.cadeia = cadeia;
		this.cadeia = cadeia;

	}


	public boolean ehAceita2(){
	// função que verifica sea a cedeia é aceita. Utiliza a ideia de busca em largura para chegar a conclusão

		int q0 = aut.getQ0(); //Estado inicial

		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> queue2 = new LinkedList<>();

		Set<Integer> marked = new HashSet<>();  // set p não repetir simbolo na "linha" do teste
		queue.add(q0);
		queue.addAll(aut.trLambda(q0)); //caso o estado inicial tenha uma transição na string vazia
										// adiciona os estados finais da transição
										// na fila de estados a serem "testados" ao ler o primeiro smbolo


		int i = 0;
		while(i<cadeia.length){ //loop para percorrer a cadeia
			while(!queue.isEmpty()){
				int s_lido = cadeia[i];
				int q = queue.poll(); 

				for(Transicao t : aut.trsc(q)){
					int qf = t.getQf(); //estado final 
					int simbolo_t = t.getSimb(); //simbolo lido da cadeia
					
					 if((simbolo_t == s_lido) && !marked.contains(qf)){ // se o simbolo lido for igual ao da transicao
						if(i == cadeia.length-1 && (aut.getQa().contains(qf))){ // chegou ao fim da cadeia e está num estado final
							return true;
						}
						else if(i < cadeia.length-1 && !ehFolha(qf, cadeia[i+1])){ //adiciona na lista de marcados e coloca na fila se não for uma folha e ainda há simbolos a ler
							queue2.add(qf);
							marked.add(qf);
						}
					}
				}

			}
			queue.addAll(queue2); // adiciona os estados possíveis para o prox simbolo
			queue2.clear();	// reseta a fila
			marked.clear(); // reseta a listad e marcados
			i++;
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

