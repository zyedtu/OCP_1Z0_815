package ocp.chapiter06;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class WorkingWithVariablesInLambdas {

	public static void main(String[] args) {
		Predicate<String> p1 = x -> true;
		Predicate<String> p2 = (var x)  -> true;
		Predicate<String> p3 = (String x) -> true; 
		consume((var x) -> System.out.println(x), 123);
		
		ArrayList<Integer> list =  new ArrayList<Integer>();
		list.add(13); list.add(-1);list.add(5);
		System.out.println("avant: " + list);
		counts(list);
		System.out.println("Après" + list);
	}

	private static void consume(Consumer<Integer> c, int num) {
		c.accept(num);
	}
	
	private static void counts(List<Integer> list) {
		list.sort((var x, var y) -> x.compareTo(y));
	}
	class Crow{
		private String color;
		public void caw(String name) {
			String volume = "loudly";
			//name= "Caty";
			color = "black";
			Consumer<String> consumer = s -> 
			System.out.println(name + " says "
					+ volume + " that she is " + color);
			//volume = "softly";
		}
	}
}
