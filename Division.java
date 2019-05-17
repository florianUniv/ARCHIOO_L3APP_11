
public class Division implements Operation{

	public double calculer(double nombre1,double nombre2)throws DivisionByZeroException {

		if(nombre2==0)
			throw new DivisionByZeroException();
		return nombre1/nombre2;

	}
}
