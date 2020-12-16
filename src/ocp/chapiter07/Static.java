package ocp.chapiter07;


public class Static {
	 private String name = "Static class";
	 public static void first() { }
	 public static void second() { }
	 public void third() { System.out.println(name); }
	 public static void main(String args[]) {
		 first();
		 second();
		 //third(); // DOES NOT COMPILE
		 //System.out.println(name); // DOES NOT COMPILE
		 new Static().third();
		 String a = new Static().name;
	 }
}
