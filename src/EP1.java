import java.util.Scanner;
import java.io.*;

public class EP1{

	public static int[] string2int(String[] str){
		int size = str.length;
	    int [] arr = new int [size];
	    for(int i=0; i<size; i++) 
      	 	arr[i] = Integer.parseInt(str[i]);
      	return arr; 	
	}

	public static void main(String[] args) throws FileNotFoundException{
		
		

		Automato a1 = new Automato(3, 3, 6, 0, 1);
		a1.addAceitacao(1);

		a1.addTransicao(0, 0, 1);
		a1.addTransicao(1, 1, 0);
		a1.addTransicao(0, 1, 2);
		a1.addTransicao(2, 2, 2);
		a1.addTransicao(2, 1, 1);
		a1.addTransicao(2, 2, 1);

		a1.verificaLambda();

		a1.printAutomato();

		int[] cadeia = {1, 2, 2, 1, 2, 2};

		TesteCadeia t = new TesteCadeia(a1, cadeia);

		System.out.println(t.ehAceita());


	}
}