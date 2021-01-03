package ocp.chapiter08;

class Penguin {
	public int getHeight() { return 3; }
	public void printInfo() {
		System.out.println(this.getHeight());
	}
}
public class EmperorPenguin extends Penguin{
	public int getHeight() { return 8; } 
	public static void main(String[] args) {
		Penguin penguin = new EmperorPenguin();
		penguin.printInfo();
	}
}
