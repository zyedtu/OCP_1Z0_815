package ocp.chapiter05;

import java.util.ArrayList;
import java.util.List;

public class UnderstandWrapperClass {

	public static void main(String[] args) {

		Integer valWrapp = Integer.valueOf(2);
		int valprimitive = valWrapp.intValue();
		int valprimitive2 = valWrapp.valueOf("2");
		String string = Integer.toString(5);
		System.out.println(string.length());
		
		float f = Float.parseFloat("1");
		Float F = Float.valueOf("2.2");
		
		String str2 = Float.toString(1.17f);
		System.out.println("String2 is: "+str2);
		
		List<Double> weights = new ArrayList<>();
		weights.add(50.5); // [50.5]
		weights.add(Double.valueOf(60)); // [50.5, 60.0]
		System.out.println(weights);
		weights.remove(50.5); // [60.0]
		double first = weights.get(0); // 60.0
		
		List<Integer> heights = new ArrayList<>();
		heights.add(null);
		//int h = heights.get(0); // NullPointerException
		System.out.println("---------------------------------");
		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.remove(1);
		System.out.println(numbers);

	}
	

}
