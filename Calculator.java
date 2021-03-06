import java.util.logging.Level;
import java.util.logging.Logger;

public class Calculator {
	
	protected double nb1;
	protected double nb2;
	protected String op;
	
	public Calculator(double nb1,double nb2,String op){

		try{
			this.nb1=nb1;
			this.nb2=nb2;
		}
		catch (NumberFormatException e) {
			Logger logger = Logger.getLogger(NumberFormatException.class.getName());
			logger.log(Level.SEVERE,"Uncaught exception",e);
		}

		try{
			this.op=op;
			if(!op.equals("+") && !op.equals("/")){
				throw new SigneException();
			}
		}
		catch(SigneException e){
			Logger logger = Logger.getLogger(SigneException.class.getName());
			logger.log(Level.SEVERE,"Uncaught exception",e);
		}

	}
	
	public double calculer() throws DivisionByZeroException{
		
		CalculatorConf c = new CalculatorConf(nb1, nb2, op);
		double resultat = c.getOperation().calculer(nb1, nb2);
		return resultat;
		
	
	}

	
}
