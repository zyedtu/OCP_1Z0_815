package ocp.chapiter02;

public class OcpTest4 {
	private String name; // instance variable 
	private static float temp; // class variable
	
	public static void main(String[] args) {
		String one, two;
		one = new String("a");
		two = new String("b");
		one = two;
		String three = one;
		one = null;
	}
	
	public void breakingDeclaration() {
		var number 
		= 7;
		number = 4;
		int x
		= 8;
	}
	public int notValid() {
		int y = 10;
		int x = 0;;
		int reply = x + y; // DOES NOT COMPILE
		return reply;
	}
	
	public void varAndNull() {
		var n = "myData";
		n = null;
		var m = 4;
//		var m = null; // DOES NOT COMPILE
		var var = 7.1; // COMPILE
	}
	
	public void eatifHungry(boolean hungry) {
		if(hungry) {
			int bitesOfCheese = 1;
			{
				var teenyBit = true;
				System.out.println(bitesOfCheese);
			}
		}
	}
	
	public void checkAnswer() {
		boolean value;
//		findAnswer(value);// DOES NOT COMPILE
	}
}

class Mouse{
	
}