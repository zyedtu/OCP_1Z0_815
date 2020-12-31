package ocp.chapiter08;

class Bear {
	public static void sneeze() {
		System.out.println("Bear is sneezing");
	}

	public void hibernate() {
		System.out.println("Bear is hibernating");
	}

	public static void laugh() {
		System.out.println("Bear is laugh");
	}
}

public class Panda extends Bear {
//	public void sneeze() { // DOES NOT COMPILE
//		System.out.println("Panda bear sneezes quietly");
//	}
//	public static void hibernate() { // DOES NOT COMPILE
//		System.out.println("Panda bear is going to sleep");
//	}
//	protected static void laugh() {	// DOES NOT COMPILE
//		System.out.println("Panda is laugh");
//	}
}

