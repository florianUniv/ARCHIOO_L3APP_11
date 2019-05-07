import java.util.HashMap;
import java.util.Map;

public class CalculatorConf extends Calculator{
	
	Map<String,Operation> m = new HashMap<>();
	
	public CalculatorConf(double nb1,double nb2,String op){
		super(nb1, nb1, op);
		m.put("+", new Addition());
		m.put("/", new Division());
	}
	
	public Operation getOperation(){
		return this.m.get(this.op);
	}

}
