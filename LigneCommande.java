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
		
		Calculator c = new Calculator(nb1, nb2, op);
		double resultat=c.calculer();
		
		
		System.out.println();
		System.out.println("|| "+nb1+" "+op+" "+nb2+" = "+resultat+" ||");
		
	}
	
	
}
