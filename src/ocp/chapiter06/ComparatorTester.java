package ocp.chapiter06;

import java.util.Comparator;

public class ComparatorTester {

	public static void main(String[] args) {
		Comparator<Integer> ints = (i1, i2) -> i1- i2;
		System.out.println(comparaison(8, 11, ints));
	}
	
	private static int comparaison(Integer o1, Integer o2, Comparator comparator) {
		return comparator.compare(o1, o2);
	}
}
