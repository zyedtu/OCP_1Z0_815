package ocp.chapiter09;

public interface Soar {
	public static final int MAX_HEIGHT = 10;
	public final static boolean UNDERWATER = true;
	public abstract void fly(int speed);
	public abstract void takeOff();
	public abstract double drive();
}
