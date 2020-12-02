package ocp.chapiter05;

import java.util.Arrays;

public class CreatingArray {

	public static void main(String[] args) {

		int [] numbers = new int[3];
		
		int[] numbers2 = new int[] {4, 52, 89};
		
		int []numAnimals3;
		
		String [] bugs = {"cricket", "beetle", "ladybug"};
		String [] alias = bugs;
		System.out.println(bugs.equals(alias));
		System.out.println(bugs.toString());
		
		String[] mammals = {"monkey", "chimp", "donkey"};
		System.out.println(mammals.length); // 3
		System.out.println(mammals[0]); // monkey
		System.out.println(mammals[1]); // chimp
		System.out.println(mammals[2]); // donkey
		
		int [] tab = {9, 5 , 1};
		Arrays.sort(tab);
		for(int i : tab)
			System.out.print(i + " ");
		System.out.println();
		Arrays.sort(mammals);
		for(String str : mammals)
			System.out.print(str + " ");
		System.out.println();
		String[] strings = { "10", "9", "100" };
		Arrays.sort(strings);
		for (String string : strings)
		 System.out.print(string + " ");
		
		System.out.println("search");
		int[] tabInt = {2,4,6,8};
		System.out.println(Arrays.binarySearch(tabInt, 2)); // 0
		System.out.println(Arrays.binarySearch(tabInt, 4)); // 1
		System.out.println(Arrays.binarySearch(tabInt, 1)); // -1
		System.out.println(Arrays.binarySearch(tabInt, 3)); // -2
		System.out.println(Arrays.binarySearch(tabInt, 9)); // -5
		System.out.println("tabNoSort");
		
		int [] tabNoSort = new int[] {3,2,1};
		System.out.println(Arrays.binarySearch(tabNoSort, 2));
		System.out.println(Arrays.binarySearch(tabNoSort, 3));
		
		System.out.println("compare");
		
		System.out.println(Arrays.compare(new int[] {1}, new int[] {2}));	//
		System.out.println(Arrays.compare(new int[] {1, 2}, new int[] {2}));	// -1
		System.out.println(Arrays.compare(new int[] {1, 2}, new int[] {1, 2}));	// 0
		System.out.println(Arrays.compare(new int[] {1, 2}, new int[] {2, 1}));	// -1
		System.out.println(Arrays.compare(new String[] {"a"}, new String[] {"aa"}));	// -1
		System.out.println(Arrays.compare(new String[] {"a"}, new String[] {"A"}));	// 32
		System.out.println(Arrays.compare(new String[] {"a"}, new String[] {null}));	//1
		
		System.out.println("mismatch");
		System.out.println(Arrays.mismatch(new int[] {1},  new int[] {1}));
		System.out.println(Arrays.mismatch(new String[] {"a"}, new String[] {"A"}));
		System.out.println(Arrays.mismatch(new int[] {1, 2},  new int[] {1}));
	}

}
