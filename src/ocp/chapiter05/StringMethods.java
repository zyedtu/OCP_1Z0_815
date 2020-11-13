package ocp.chapiter05;

import java.time.LocalDate;

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
		
		System.out.println(s.substring(3));
		System.out.println(s.substring(7));
		System.out.println(s.substring(s.indexOf('m')));
		System.out.println(s.substring(3, 4));
		System.out.println(s.substring(3, 3));
//		System.out.println(s.substring(5, 4));
//		System.out.println(s.substring(5, 8));
		
		String str = "robin";
		System.out.println(str.toUpperCase());
		System.out.println("ABC123".toLowerCase());
		
		System.out.println("abc".equals("ABC"));
		System.out.println("abc".equals("abc"));
		System.out.println("abc".equalsIgnoreCase("ABC"));
		
		System.out.println("---------------------------------------");
		
		System.out.println("abc".startsWith("a"));
		System.out.println("abc".startsWith("A"));
		System.out.println("abc".endsWith("c"));
		System.out.println("abc".endsWith("a"));
		System.out.println("---------------------------------------");
		
		System.out.println("abcab".replace('a', 'A'));
		System.out.println("abcab".replace("bc", "BC"));
		System.out.println("---------------------------------------");
		System.out.println("abc".contains("a"));
		System.out.println("abc".contains("B"));

		System.out.println("strip(): "+ "\t  a b c \n".strip());
		System.out.println("trim(): "+ "\t  a b c \n".trim());
		String text = " abc\t ";
		System.out.println("trim(): "+ text.trim().length());
		System.out.println("strip(): "+ text.strip().length());
		System.out.println("stripLeading(): "+ text.stripLeading().length());
		System.out.println("stripTrailing(): "+ text.stripTrailing().length());
		System.out.println("------------------Chaining--------------------");
		String start = "AniMaL ";
		String trimmed = start.trim();
		String lowercase = trimmed.toLowerCase();
		String result = lowercase.replace('a', 'A');
		System.out.println(result);
		
		String res = "AniMal ".trim().toLowerCase().replace('a', 'A');
		System.out.println(res);
	}

}
