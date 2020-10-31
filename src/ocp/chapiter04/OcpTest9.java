package ocp.chapiter04;

public class OcpTest9 {

	public static void main(String[] args) {

		int [][] list = {{1,13}, {5,2}, {2,2}};
		int searchValue = 2;
		int positionX = -1;
		int positionY = -1;
		PARENT_LOOP: for(int i=0; i<list.length; i++) {
			for(int j=0; j<list[i].length; j++) {
				if(list[i][j] == searchValue) {
					positionX = i;
					positionY = j;
					break PARENT_LOOP;
				}
			}
		}
		System.out.println("Value found at: ("+ positionX + "," + positionY+")" );
		
		for(int i=0; i<list.length; i++) {
			for(int j=0; j<list[i].length; j++) {
				if(list[i][j] == searchValue) {
					positionX = i;
					positionY = j;
					break;
				}
			}
		}
		System.out.println("Value found without label at: ("+ positionX + "," + positionY+")" );
		
	}
}
