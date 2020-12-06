package ocp.chapiter06;

import java.util.function.Supplier;


public class SupplierGet {

	public static void main(String[] args) {
		Supplier<Integer> number = () -> 42;
		Supplier<Double> random = () -> Math.random();
		System.out.println(returnNumber(number));
		System.out.println(random.get());
	}
	
	private static int returnNumber(Supplier<Integer> supplier) {
		return supplier.get();
	}
}
