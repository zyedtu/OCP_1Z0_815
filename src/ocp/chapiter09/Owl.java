package ocp.chapiter09;

interface Nocturnal {
	int hunt();
}
interface CanFly {
	void flap();
}
interface HasBigEyes extends Nocturnal, CanFly { }
public class Owl implements Nocturnal, CanFly {
	public void flap() { System.out.println("Flap!");}
	public int hunt() { return 5; }
}
