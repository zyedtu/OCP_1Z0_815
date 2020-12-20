package ocp.chapiter07;

public class Plane {

	public static void main(String[] args) {
		Plane p = new Plane();
		 p.fly(123);
		 p.fly(123L);
	}

	public void fly(int i) {
		System.out.println("int ");
	}
	
	public void fly(long l) {
		System.out.println("long ");
	}
}
