package printnumbers;

import org.junit.Test;

public class PrintNumbersTest {
	
	@Test
	public void testPrintNumbers1toX() {
		PrintNumbers printNumbers = new PrintNumbers();
		
		printNumbers.printNumbersFrom1toX(100);
	}

}
