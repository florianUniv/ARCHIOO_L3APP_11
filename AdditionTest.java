import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AdditionTest {

	@Before
	public void setUp() throws Exception {
	}

	@SuppressWarnings("deprecation")
	@Test
	public void test() throws DivisionByZeroException{
		Operation add = new Addition();
		assertEquals(2,add.calculer(1,1),0.00001);
	}

	public void test0() throws DivisionByZeroException{
		Operation add = new Addition();
		assertEquals(0,add.calculer(-10,10),0.00001);
	}
}
