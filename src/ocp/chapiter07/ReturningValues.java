package ocp.chapiter07;

public class ReturningValues {
	public static void main(String[] args) {
		int number = 1; // 1
		String letters = "abc"; // abc
		number(number); // 1
		letters = letters(letters); // abcd
		System.out.println(number + letters); // 1abcd
	}

	public static int number(int number) {
		number++;
		return number;
	}
	
	public static String letters(String letters) {
		letters += "d";
		return letters;
	}
}
