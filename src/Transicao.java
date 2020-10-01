import java.util.Scanner;
import java.util.ArrayList;


public class Transicao{
	private int qi;
	private int qf;
	private int simb;

	public Transicao(int qi, int simb, int qf){
		this.qi = qi;
		this.simb = simb;
		this.qf = qf;
	}

	public Integer getQi(){
		return qi;
	}

	public Integer getQf(){
		return qf;
	}

	public Integer getSimb(){
		return simb;
	}

	public String toString(){
		return String.format("q%d-%d-q%d", qi, simb, qf);
	}


}