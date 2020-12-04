package ocp.chapiter05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConversionListTab {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("hawk");
		list.add("robin");
		Object[] objectArray = list.toArray();
		String[] stringArray = list.toArray(new String[0]);
		list.clear();
		System.out.println(objectArray.length);
		System.out.println(stringArray.length);
		System.out.println("----------------------------------------------------");
		String[] array = { "hawk", "robin" }; // [hawk, robin]
		List<String> liste = Arrays.asList(array); // returns fixed size list
		System.out.println(liste.size()); // 2
		liste.set(1, "test"); // [hawk, test]
		array[0] = "new"; // [new, test]
		for (String b : array) System.out.print(b + " "); // new test
		System.out.println(liste);	// [new, test]
		//liste.remove(1); // throws UnsupportedOperation Exception
		System.out.println("----------------------------------------------------");
		List<String> list1 = Arrays.asList("one", "two");
		List<String> list2 = List.of("one", "two");
		System.out.println("----------------------------------------------------");
		List<String> fixedSizeList = Arrays.asList("a", "b", "c");
		List<String> expandableList = new ArrayList<String>(fixedSizeList);
		System.out.println("----------------------------------------------------");
		List<Integer> numbers = new ArrayList<>();
		numbers.add(99);
		numbers.add(5);
		numbers.add(81);
		Collections.sort(numbers);
		System.out.println(numbers);// [5, 81, 99]
	}

}
