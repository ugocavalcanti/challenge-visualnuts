package printnumbers.functions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MathFuctionTest {
	
	MathFunctions mathFuction;
	
	@Before
	public void init() {
		mathFuction = new MathFunctions();
	}
	
	@Test
	public void testDivisibleBy3() {
		
		Integer number = 921;
		
		assertTrue(mathFuction.isDivisibleBy3(number));
		
	}
	
	@Test
	public void testDivisibleBy3False() {
		
		Integer number = 922;
		
		assertFalse(mathFuction.isDivisibleBy3(number));
		
	}
	
	@Test
	public void testDivisibleBy5() {
		
		Integer number = 1255;
		
		assertTrue(mathFuction.isDivisibleBy5(number));
		
	}
	
	@Test
	public void testDivisibleBy5False() {
		
		Integer number = 1251;
		
		assertFalse(mathFuction.isDivisibleBy5(number));
		
	}

}
