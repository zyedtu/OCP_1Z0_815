package ocp.chapiter04;

public class OcpTest8 {

	public static void main(String[] args) {

//		for(long y = 0, x = 4; x < 5 && y < 10; y++) {
//			System.out.print(y + " ");
//		}

//		for(int i=0; i<10; i++)
//			i=0;
//		for(int j=0; j<10; j++) {
//			j--;
//			System.out.println("j " + j);
//		}
		for(int k=0; k<10;) {
			k++;
			System.out.println("k " + k);
		}
		
		final String[] names = new String[3];
		names[0] = "Lisa";
		names[1] = "Kevin";
		names[2] = "Roger";
		for(String name : names)
			System.out.print(name + ", ");
		System.out.println();
		int [][] myComplexArray = {{5,2,1,3}, {3,9,8,9}, {5,7,12,7}};
		OUTER_LOOP: for(int[] mySimpleArray: myComplexArray) {
			INNER_LOOP: for(int i=0; i<mySimpleArray.length; i++)
				System.out.print(mySimpleArray[i]+"\t");
			System.out.println();
		}
		
//		int checkDate = 0;
//		while(checkDate < 10) {
//			if(checkDate>100) {
//				break;
//				checkDate++;
//			}
//		}
//		
//		int minute = 1;
//		WATCH: while(minute > 2) {
//			if(minute++ >2) {
//				continue WATCH;
//				System.out.println(minute);
//			}
//		}
	}

}
