package ocp.testCode;

public class WhizlabsTes2 {

	public static void main(String[] args) {
		int x = 1, y = 2;
		x += x < y ? y : x;
		y = x < y ? y - x : y + x ;
		System.out.println(y);
		System.out.println(x + " " + y);	}
}
