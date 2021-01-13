package ocp.chapiter09;

interface CanBurrow {}

interface Climb {
	Number getSpeed(int age);
}

public class FieldMouse implements Climb, CanBurrow{
	public Number getSpeed(int age) {
		return 11f;
	}
//	public static void main(String[] args) {
//	}
}
