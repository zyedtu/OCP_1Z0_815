package ocp.chapiter04;

public class OcpTest1 {

	public static void main(String[] args) {

		int month = 5;
		
		switch (month) { 
		case 1 | 5: System.out.println("January");// DOES NOT COMPILE
		}
		
		short size = 4;
		final int small = 15;
		final int big = 1_000_000;
		switch(size) {
		case small:
		case 1+2:
//		case big:
		}
	}

}
