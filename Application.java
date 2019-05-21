import java.io.IOException;

public class Application {

	public static void main(String [] args) throws DivisionByZeroException, ClassNotFoundException, IOException{


		//START SERVER
		new Thread(new Runnable() {

			@Override
			public void run() {

				ServiceCalculatrice sc = new ServiceCalculatrice();
				try {
					sc.lunch();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (DivisionByZeroException e) {
					e.printStackTrace();
				}

			}
		}).start();

		LigneCommande lc = new LigneCommande();
		lc.lancer();

	}
}
