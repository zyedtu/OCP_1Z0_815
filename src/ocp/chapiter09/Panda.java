package ocp.chapiter09;

abstract class Bear {
	abstract CharSequence chew();
	public Bear() {
		System.out.println(chew());
	}
}
public class Panda extends Bear{
	CharSequence chew() { return "yummt!"; }
	public static void main(String[] args) {
		new Panda();
	}
}
