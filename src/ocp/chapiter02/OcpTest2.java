package ocp.chapiter02;

public class OcpTest2 {

	public static void main(String[] args) {

		boolean b = true;
		byte a = 12; // 8-bit
		short x = 156;// 16-bit
		int n = -45;// 32-bit
		long l = 1238L;// 64-bit
		float f = 15.14f;// 32-bit floating-point
		double d = 1478.489;// 64-bit floating-point
		char c = 'h';// 16-bit unicode value
		
		short bird = 'd';
		char mammal = (short) 83;
		System.out.println(bird);
		System.out.println(mammal);
		
		int amount = 0156;
		System.out.println(amount);
		char [] carray = {'\u004F', '\u0043', '\u0041'}; 
		System.out.println("Unicode: " +carray[0]+""+carray[1]+""+carray[2]);

		char c1 = 's';
		char c2 = '\u0068';
		char c3 = 0x0065;
		char c4 = 0154;
		System.out.println("Yasmine : "+c1+", "+c2+", "+c3+", "+c4);

	}

}
