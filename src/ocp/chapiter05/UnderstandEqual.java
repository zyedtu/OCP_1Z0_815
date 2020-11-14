package ocp.chapiter05;

public class UnderstandEqual {

	public static void main(String[] args) {
		StringBuilder one = new StringBuilder();
		StringBuilder two = new StringBuilder();
		StringBuilder three = one.append("a");
		System.out.println(one == two); // false
		System.out.println(one == three); // true
		
		String x = "Hello World";
		String y = "Hello World";
		System.out.println(x == y); // true
		
		String s1 = new String();
		String s2 = new String();
		System.out.println("="+ s1.equals(s2));
		
		String str = "a";
		StringBuilder builder = new StringBuilder("a");
//		System.out.println(str == builder);
		
		String singleString = "hello world";
		String oneLine = "hello " + "world";
		String concat = "hello ".concat("world");
		System.out.println(singleString == oneLine);
		System.out.println(singleString == concat);
		
		String a = "ab c";
		String b = "ab "+"c";
		String c = "ab c ".strip();
		System.out.println(a == b);
		System.out.println(a == c);
		
		System.out.println("*************************");
		
		String name = "Hello world";
		String name2 = new String("Hello world").intern();
		System.out.println(name == name2);
 	}

}
