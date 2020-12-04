package ocp.chapiter05;

import java.util.HashSet;
import java.util.Set;

public class ImpleSet {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		System.out.println(set.add(66));	// true
		System.out.println(set.add(66));	// flase
		System.out.println(set.size());	// 1
		set.remove(66);
		System.out.println(set.isEmpty());	// true
	}

}
