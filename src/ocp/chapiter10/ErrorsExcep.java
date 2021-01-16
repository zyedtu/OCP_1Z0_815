package ocp.chapiter10;

public class ErrorsExcep {
	static {
		int[] countsOfMoose = new int[3];
		int num = countsOfMoose[-1];
	}
	
	public static void main(String[] args) {
	}
}
