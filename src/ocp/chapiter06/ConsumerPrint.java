package ocp.chapiter06;

import java.util.function.Consumer;

public class ConsumerPrint {

	public static void main(String[] args) {
		Consumer<String> consumer = x -> System.out.println(x);
		print(consumer, "Hello World");
	}
	
	private static void print(Consumer<String> consumer, String value) {
		consumer.accept(value);
	}
}
