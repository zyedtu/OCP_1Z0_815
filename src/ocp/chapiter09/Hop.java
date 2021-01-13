package ocp.chapiter09;

public interface Hop {
	static int getJumpHeight() {
		return 8;
	}
}

class Bunny implements Hop {
	public void printDetails() {
		System.out.println(Hop.getJumpHeight()); // DOES NOT COMPILE
	}
}
