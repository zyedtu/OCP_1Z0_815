package ocp.chapiter09;

interface Walk {
	public default int getSpeed() {
		return 5;
	}
}
interface Run {
	public default int getSpeed() {
		return 10;
	}
}
//public class Cat implements Walk, Run{
//	public static void main(String[] args) {
//		System.out.println(new Cat().getSpeed());
//	}
//}
