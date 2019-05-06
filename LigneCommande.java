import java.util.Scanner;

public class LigneCommande implements IHM{


	@Override
	public void lancer() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Entrez le 1er nombre : ");
		double nb1= sc.nextDouble();
		System.out.print("Entrez le 2ème nombre : ");
		double nb2= sc.nextDouble();
		System.out.print("Entrez l'opérande : ");
		String op = sc.next();
		
		double resultat=0;
		
		switch (op) {
		case "+":
			Operation add = new Addition();
			resultat = add.calculer(nb1, nb2);
			break;
		case "/":
			Operation div = new Division();
			resultat = div.calculer(nb1, nb2);
			break;
			
		default:
			break;
		}
		
		System.out.println();
		System.out.println("|| "+nb1+" "+op+" "+nb2+" = "+resultat+" ||");
		
	}
	
	
}
