import java.util.Scanner;


public class EP1{
	public static void main(String[] args) {
		Automato a1 = new Automato(2, 3, 4, 0, 1);
		a1.addAceitacao(0);

		a1.addTransicao(0, 1, 0);
		a1.addTransicao(0, 1, 1);
		a1.addTransicao(0, 2, 1);
		a1.addTransicao(1, 2, 0);

		a1.printAutomato();

		int[] cadeia = {1, 2, 2, 1, 1, 1, 2, 2, 1};

		TesteCadeia t = new TesteCadeia(a1, cadeia);

		System.out.println(t.ehAceita());
	}
}