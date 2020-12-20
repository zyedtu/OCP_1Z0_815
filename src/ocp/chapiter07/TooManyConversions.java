package ocp.chapiter07;

public class TooManyConversions {

	public static void play(Long l) { }
	public static void play(Long... l) { }
	
	public static void main(String[] args) {
//		play(4); // DOES NOT COMPILE
		play(4L); // calls the Long version
	}
}
