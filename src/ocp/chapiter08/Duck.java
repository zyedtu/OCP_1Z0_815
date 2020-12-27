package ocp.chapiter08;

public class Duck {

	private String color;
	private int height;
	private int length;
	
	public void setData(int length, int theHeight) {
		length = this.height; // Backward - no good
		height = theHeight;	// Fine because a different name
		this.color = "white";	// Fine, but this not necessary
	}
	public static void main(String[] args) {
		Duck b = new Duck();
		b.setData(1, 2);
		System.out.println(b.length +" " + b.height + " " + b.color);
	}
}
