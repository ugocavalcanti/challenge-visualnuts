package printnumbers;

import printnumbers.functions.MathFunctions;

public class PrintNumbers {

	public void printNumbersFrom1toX(int x) {
		
		MathFunctions mathFuction = new MathFunctions();
		
		for (int i = 1; i <= x; i++) {
			if (mathFuction.isDivisibleBy3(i) && mathFuction.isDivisibleBy5(i)) {
				System.out.println("Visual Nuts");
			}else if (mathFuction.isDivisibleBy5(i)) {
				System.out.println("Nuts");
			}else if (mathFuction.isDivisibleBy3(i)) {
				System.out.println("Visual");
			}else {
				System.out.println(i);
			}
		}

	}

}
