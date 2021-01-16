package ocp.chapiter10;

public class RuntimeExcep {
	int numberEggs;
	public static void main(String[] args) {
		Integer.parseInt("abc");
	}
	public void setNumberEggs(int numberEggs) {
		if (numberEggs < 0)
			throw new IllegalArgumentException(
					 "# eggs must not be negative");
		this.numberEggs = numberEggs;
	}
	
}
