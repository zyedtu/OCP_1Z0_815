package ocp.chapiter07;

public class Gorilla {
	public static int count;
	public static void addGorilla() { count++; }
	public void babyGorilla() { count++; }
	
	public void announceBabies() {
		addGorilla();
		babyGorilla();
	}
	
	public static void announceBabiesToEveryone() {
		addGorilla();
		//babyGorilla(); // DOES NOT COMPILE
		Gorilla gorilla = new Gorilla();
		gorilla.babyGorilla();// COMPILE method instance
	}
	public int total;
	//public static average = total / count; // DOES NOT COMPILE
}
