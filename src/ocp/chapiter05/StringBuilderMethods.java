package ocp.chapiter05;

public class StringBuilderMethods {
	
	public static void main(String[] args) {
//		StringBuilder sb = new StringBuilder("start");
//		sb.append("+middle");
//		StringBuilder same = sb.append("+end");
//		System.out.println(sb);
//		System.out.println(same);
		System.out.println("---------------------------------------------------");
		
		StringBuilder strB = new StringBuilder("animals"); 
		String sub = strB.substring(strB.indexOf("a"), strB.indexOf("al"));
		int len = strB.length();
		char ch = strB.charAt(6);
		System.out.println(sub + " " + len + " " + ch);
		System.out.println("---------------------------------------------------");
//		StringBuilder sb = new StringBuilder().append(1).append('c').append("-").append(true);
//		System.out.println(sb);
		System.out.println("---------------------------------------------------");
//		StringBuilder sb = new StringBuilder("animals");
//		sb.insert(7, "-");
//		sb.insert(0, "-");
//		sb.insert(4, "-");
//		System.out.println(sb);
		System.out.println("---------------------------------------------------");
//		StringBuilder sb = new StringBuilder("abcdef");
//		sb.delete(1, 3);
//		sb.deleteCharAt(5);
		System.out.println("---------------------------------------------------");
		StringBuilder builder = new StringBuilder("pigeon dirty");
		builder.replace(3, 6, "sty");
		System.out.println(builder);
		builder.delete(1, 100);
		System.out.println(builder);
	}
	
}
