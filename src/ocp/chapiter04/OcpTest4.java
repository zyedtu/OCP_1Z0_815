package ocp.chapiter04;

public class OcpTest4 {

	public static void main(String[] args) {

		final int bananas = 1;
		int apples = 2;
		int numberofAnimals = 3;
		final int cookies = getCookies();
//		switch(numberofAnimals) {
//			case bananas:
//			case apples: // DOES NOT COMPILES
//			case getCookies(): // DOES NOT COMPILES
//			case cookies: // DOES NOT COMPILES
//			case 3* 5:
//		}
	}
	
	static final int getCookies() {return 4;}

}
