package printnumbers.functions;

public class MathFunctions {
	
	
	public boolean isDivisibleBy3(Integer number) {
		String strNumber = String.valueOf(number);
		
		int sum = 0;
		
		for (int i = 0; i < strNumber.length(); i++) {
			int num = Character.getNumericValue(strNumber.charAt(i));
			sum += num;
		}
		
		return sum % 3 == 0;
	}
	
	
	public boolean isDivisibleBy5(Integer number) {
		
		String strNumber = String.valueOf(number);
		
		Integer num = Character.getNumericValue(strNumber.charAt(strNumber.length()-1));
			
		return (num == 0 || num ==5);
	}

}
