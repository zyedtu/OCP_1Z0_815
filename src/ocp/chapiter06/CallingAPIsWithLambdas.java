package ocp.chapiter06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CallingAPIsWithLambdas {
	public static void main(String[] args) {
		List<String> bunnies = new ArrayList<String>();
		bunnies.add("long ear");		
		bunnies.add("floppy");		
		bunnies.add("hoppy");
		System.out.println(bunnies);
		bunnies.removeIf(s -> s.charAt(0) != 'h');
		System.out.println(bunnies);
		bunnies.sort((b1, b2) -> b1.compareTo(b2));
		System.out.println(bunnies);
		
		bunnies.forEach(b -> System.out.print(b + ", "));
		
		System.out.println("----------------------------------------");
		Map<String, Integer> bun = new HashMap<>();
		bun.put("long ear", 3);		
		bun.put("floppy", 8);		
		bun.put("hoppy", 1);		
		bun.keySet().forEach(b -> System.out.print(b + " "));
		bun.values().forEach(b -> System.out.print(b + " "));
		System.out.println("----------------------------------------");
		bun.forEach((k, v) -> System.out.println(k + " " + v));
	}
}
