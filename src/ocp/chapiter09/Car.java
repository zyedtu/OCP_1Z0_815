package ocp.chapiter09;

interface Vehicle {
	default void print() {
		System.out.println("I am a vehicle!");
	}
}
public class Car implements Vehicle{
	public static void main(String[] args) {
		new Car().print();
	}
}
