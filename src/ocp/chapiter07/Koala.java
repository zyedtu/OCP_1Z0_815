package ocp.chapiter07;

public class Koala {
	public static int count = 0;
	public static void main(String[] args) {
		Koala k = new Koala();
		System.out.println(k.count); // k is a Koala
		k = null;
		System.out.println(k.count); // k is still a Koala
		
		Koala.count = 4;
		Koala koala1 = new Koala();
		Koala koala2 = new Koala();
		koala1.count = 6;
		koala2.count = 5;
		System.out.println(Koala.count);
	}
}
