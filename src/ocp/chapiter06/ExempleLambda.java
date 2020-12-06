package ocp.chapiter06;

import java.util.ArrayList;
import java.util.List;


public class ExempleLambda {
	public static void main(String[] args) {
		List<Animal> animals = new ArrayList<Animal>(); // list of animals
		animals.add(new Animal("fish", false, true));
		animals.add(new Animal("kangaroo", true, false));
		animals.add(new Animal("rabbit", true, false));
		animals.add(new Animal("turtle", false, true));
		
		print(animals, new CheckIfHopper()); // pass class that does check
		// use Lambda expression
		print(animals, a-> a.canHop());	// kangaroo rabbit
		print(animals, a-> !a.canHop());	// fish turtle
		
	}
	
	private static void print(List<Animal> animals, CheckTrait checker) {
		for (Animal animal : animals) {
			if (checker.test(animal)) // the general check
				System.out.print(animal + " ");
		}
		System.out.println();
	}
}
