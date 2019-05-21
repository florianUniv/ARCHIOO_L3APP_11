import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DivisionTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws DivisionByZeroException {
		Operation div = new Division();
		assertEquals(1,div.calculer(1,1),0.00001);
	}

	@Test(expected = DivisionByZeroException.class)
	public void testDivisionZero() throws DivisionByZeroException {
		Operation div = new Division();
		div.calculer(1,0);
	}
}
