import java.util.Scanner;

public class LigneCommande implements IHM{


	@Override
	public void lancer() throws DivisionByZeroException {
		Scanner sc = new Scanner(System.in);
		
		double nb1=0;
		double nb2=0;
		String op="";
		
		do{
			try{
				System.out.print("Entrez le 1er nombre : ");
				nb1= Double.parseDouble(sc.next());
				break;
			}
			catch(NumberFormatException e){
				System.out.println("Veuillez saisir un nombre SVP");
			}
		}while(true);
		
		
		do{
			try{
				System.out.print("Entrez le 2ème nombre : ");
				nb2= Double.parseDouble(sc.next());
				break;
			}
			catch(NumberFormatException e){
				System.out.println("Veuillez saisir un nombre SVP");
			}	
		}while(true);
		
		
		do{
			try{
				System.out.print("Entrez l'opérande : ");
				op =  sc.next();
				if(!op.equals("+") && !op.equals("/")){
					throw new SigneException();
				}
				break;
			}
			catch(SigneException e){
				System.out.println("Signe incorrect!");
			}
		}while(true);
			
		Calculator c = new Calculator(nb1, nb2, op);
		double resultat = 0;
		
		try{
			resultat = c.calculer();
			System.out.println();
			System.out.println("|| "+nb1+" "+op+" "+nb2+" = "+resultat+" ||");
		}
		catch (DivisionByZeroException e) {
			System.out.println("Impossible de diviser par zéro!");
		}
	}
	
}
