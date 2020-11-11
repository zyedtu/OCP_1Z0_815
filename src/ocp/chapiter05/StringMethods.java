package ocp.chapiter05;

public class StringMethods {

	public static void main(String[] args) {

		String s = "animals";
		System.out.println(s.length());
		
		System.out.println(s.charAt(0));
		System.out.println(s.charAt(6));
//		System.out.println(s.charAt(7));
		System.out.println(s.indexOf(1));
		System.out.println(s.indexOf('a'));
		System.out.println(s.indexOf("al"));
		System.out.println(s.indexOf('a', 4));
		System.out.println(s.indexOf("al",5));
		
//		System.out.println(s.substring(3));
//		System.out.println(s.substring(7));
//		System.out.println(s.substring(s.indexOf('m')));
//		System.out.println(s.substring(3, 4));
		System.out.println(s.substring(3, 3));
		System.out.println(s.substring(5, 4));
//		System.out.println(s.substring(5, 8));
	}

}
