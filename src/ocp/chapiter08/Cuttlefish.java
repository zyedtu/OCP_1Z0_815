package ocp.chapiter08;

public class Cuttlefish {
	private String name = "swimmy";
	{ System.out.print(name+"-"); }
	private static int COUNT = 0;
	static { System.out.print(COUNT+"-");}
	{ COUNT++; System.out.print(COUNT+"-"); }
	
	public Cuttlefish() {
		System.out.println("Constructor");
	}
	public static void main(String[] args) {
		System.out.print("Ready-");
		new Cuttlefish();
	}
}
