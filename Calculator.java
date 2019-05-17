
public class Calculator {
	
	protected double nb1;
	protected double nb2;
	protected String op;
	
	public Calculator(double nb1,double nb2,String op){
		this.nb1=nb1;
		this.nb2=nb2;
		this.op=op;
	}
	
	public double calculer() throws DivisionByZeroException{
		
		CalculatorConf c = new CalculatorConf(nb1, nb2, op);
		double resultat = c.getOperation().calculer(nb1, nb2);
		return resultat;
		
	
	}

	
}
