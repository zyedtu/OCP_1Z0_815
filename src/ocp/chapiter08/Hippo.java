package ocp.chapiter08;

class AnimalT{
	static {System.out.print("A");}
}
public class Hippo extends AnimalT{
	static {System.out.print("B");}
	public static void main(String[] args) {
		System.out.print("C");
		new Hippo();
		new Hippo();
		new Hippo();
	}
}
