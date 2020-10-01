import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;


public class Automato{
	private ArrayList<Integer> alfabeto = new ArrayList();
	private LinkedList<Transicao> lista[];
	private ArrayList<Integer> qa;
	private Integer q0; 
	private Integer estados;

	public Automato(int q, int s, int t, int q0, int a){
		this.lista = new LinkedList[q];
		this.estados = q;

		for(int i=0; i<q;i++){
			lista[i] = new LinkedList<>();
		}
		for(int i=0; i<s;i++)
			alfabeto.add(i);

		this.q0 = q0;
		this. qa = new ArrayList();
	}

	public void addTransicao(int qi, int s, int qf){
		lista[qi].add(new Transicao(qi, s, qf));
	}

	public void addAceitacao(int qf){
		qa.add(qf);
	}

	public void printAutomato(){
        System.out.println("Estado inicial: " + q0);
        System.out.println("Estados de aceitacao: " + qa.toString());
        System.out.println();

        for (int i = 0; i < estados; i++) {
            if(lista[i].size()>0) {
                System.out.print("Estado " + i + " is connected to: ");
                
                for (int j = 0; j < lista[i].size(); j++) {
                    System.out.print(lista[i].get(j) + " ");
                }
                
                System.out.println();
            }   
        }
    }

    public Iterable<Transicao> trsc(Integer estado){
    	return lista[estado];
    }

    public Integer getQ0(){
    	return q0;
    }

    public Integer getEstados(){
    	return this.estados;
    }

    public ArrayList<Integer> getQa(){
    	return qa;
    }

}


	

