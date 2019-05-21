import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LigneCommande implements IHM{

	private static int PORT = 33002;
	private static final Logger LOGGER = Logger.getLogger(LigneCommande.class.getName());

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



		Socket socket;
		try {
			socket = new Socket(InetAddress.getLocalHost(), PORT);


			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

			LOGGER.log(Level.INFO,"connexion établit coté client");

			//On envoie au serveur:
			oos.writeObject(nb1);
			oos.writeObject(nb2);
			oos.writeObject(op);

			ObjectInputStream  ois = new ObjectInputStream(socket.getInputStream());

			double resultat = (double) ois.readObject();
			System.out.println("Le résultat est "+resultat);

			socket.close();

		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
