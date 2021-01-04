package ocp.chapiter09;

abstract class Bird {
	public abstract String getName();
	public void printName() {
		System.out.println(getName());
	}
}
public class Stork extends Bird{
	public String getName() { return "Stork!"; }
	public static void main(String[] args) {
		new Stork().printName();
	}
}
