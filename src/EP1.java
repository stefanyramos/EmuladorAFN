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
		
		File file = new File(args[0]);

		Scanner sc = new Scanner(file);
		PrintWriter out = new PrintWriter(args[1]);

		int m = sc.nextInt();

		int q,s,t,q0,a;

		for(int i = 0; i<m; i++){
			q = sc.nextInt();	// n estados
			s = sc.nextInt();	// n simbolos no alfabeto
			t = sc.nextInt();	// n transicoes
			q0 = sc.nextInt();	// estado inicial
			a = sc.nextInt();	// n estados de aceitacao

			Automato A = new Automato(q, s, t, q0, a);

			for(int k=0; k<a; k++){
				int e = sc.nextInt();
				A.addAceitacao(e);
			}

			for(int j=0; j<t; j++){
				int qi = sc.nextInt();
				int simb = sc.nextInt();
				int qf = sc.nextInt();
				A.addTransicao(qi, simb, qf);
			}

			A.verificaLambda(); //adiciona as transições com (Lambda) se houver


			int teste = sc.nextInt(); // numero de testes

			sc.nextLine();
			for(int l=0; l<teste; l++){				
				String cadeiaS = sc.nextLine();

				String[] cadeiaS1 = cadeiaS.split(" ");
				int[] cadeia = string2int(cadeiaS1);

				TesteCadeia tc = new TesteCadeia(A, cadeia); // testa a cadeia
				out.print((tc.ehAceita2() ? 1 : 0) + " "); // printa o resultado no arquivo de saida
				
			}
			out.println();
		}

		out.close();

	
	

	}
}