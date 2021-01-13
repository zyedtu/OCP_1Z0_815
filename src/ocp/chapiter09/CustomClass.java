package ocp.chapiter09;

interface CustomInterface {
	public default void method2() {
		method4(); // private method inside default method
		method5(); // static method inside other non-static method
		System.out.println("default method");
	}

	private void method4() {
		System.out.println("private method");
	}

	private static void method5() {
		System.out.println("private static method");
	}
}

public class CustomClass implements CustomInterface{
	public static void main(String[] args) {
		new CustomClass().method2();

	}
}
