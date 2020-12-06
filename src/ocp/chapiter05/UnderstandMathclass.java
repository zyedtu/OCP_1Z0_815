package ocp.chapiter05;

public class UnderstandMathclass {

	public static void main(String[] args) {
		int first = Math.max(3, 7);
		int second = Math.min(8, -9);
		System.out.println("first is: " + first + ", and second is: " + second);
		
		long low = Math.round(123.45);
		long high = Math.round(123.50);
		int formfloat = Math.round(123.45f);
		
		System.out.println(low + ", " + high + ", "+ formfloat);
		
		double squared = Math.pow(5, 2);
		
		double num = Math.random();	
		System.out.println(num);
	}

}
