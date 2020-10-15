package ocp.chapiter03;

public class OcpTest1 {

	public static void main(String[] args) {
		int height = 7;
		int length = 3;
		var perimeter = 2 * height + 2 * length;
		System.out.println(perimeter);
		
		boolean isAnimalAsleep = false;
		System.out.println(isAnimalAsleep); //false
		System.out.println(!isAnimalAsleep); //true
		
		double zooTemperature = 1.21;
		System.out.println(zooTemperature); //-1.21
		System.out.println(-zooTemperature); //-1.21
		
		int parkAttendance = 0;
		System.out.println(parkAttendance); //0
		System.out.println(++parkAttendance); //1
		System.out.println(parkAttendance); //1
		System.out.println(parkAttendance--); //1
		System.out.println(parkAttendance); //0
		
		int x = 5;
		int y = 4;
		System.out.println(x == y); // false
		System.out.println(x != y); // true
		
//		int y = ++x + --x;
//		System.out.println(y);
//		

		boolean b = true;
		boolean a = false;
		System.out.println(a == b); //false
		
		Integer zooTime = Integer.valueOf(9);
		Number num = zooTime;
		Object obj = zooTime;
		
		if(zooTime instanceof Integer) {
			System.out.println((Integer) zooTime + " O'clock");
		}else
			System.out.println(zooTime);
		

		boolean eyesClosed = true;
		boolean breathingSlowly = true;
		System.out.println(eyesClosed & breathingSlowly); // true
		System.out.println(eyesClosed | breathingSlowly); // true
		System.out.println(eyesClosed ^ breathingSlowly); // false
		
		int hour = 10;
		boolean zooOpen = true || (hour < 4);
		System.out.println(zooOpen);  // true
		
		int rabbit = 6;
		boolean bunny = (rabbit >= 6 ) || (++rabbit <= 7);
		System.out.println(rabbit);
		
		int stripes = 3;
		System.out.println((stripes > 5 ) ? 21 : "Zebra"); // Zebra
	}

}
