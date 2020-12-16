package ocp.chapiter07;

public class PassingDataamongMethods {

	public static void main(String[] args) {
		int num = 4;
		newNumber(num);
		System.out.println(num);	// 4
		System.out.println("------------------------------------------");
		
		 String name = "Webby";
		 speak(name);
		 System.out.println(name);
		 System.out.println("------------------------------------------");
		 
		 StringBuilder sb = new StringBuilder("Sparky");
		 speak(sb);
		 System.out.println(sb); // SparkyWebby

	}
	
	public static void newNumber(int num) { num = 8; }
	
	public static void speak(String name) { name = "Sparky"; }
	
	public static void speak(StringBuilder s) { s.append("Webby"); }
}
