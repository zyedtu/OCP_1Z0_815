package ocp.chapiter08;

public class Turtle {
	private String name;
	
	public Turtle() {
		name = "John Doe";
	}
	public Turtle(int age) {}
	public Turtle(long age) {}
	public Turtle(String newName, String... favoriteFoods) {
		name = newName;
	}
}

