package ocp.chapiter04;

public class OcpTest11 {

	public static void main(String[] args) {
		int [][] list = {{1,13}, {5,2}, {2,2}};
		int searchValue = 2;
		int [] results = searchForValue(list, searchValue);
		if(results == null) {
			System.out.println("Value "+searchValue+" not found");
		}else {
			System.out.println("Value "+searchValue+" found at: "+"("+results[0]
					+","+results[1]+")");
		}
		
	}
	
	private static int[] searchForValue(int[][] array, int v) {
		for(int i = 0; i < array.length; i++) {
			for(int j=0; j < array[i].length; j++ ) {
				if(array[i][j] == v)
					return new int[] {i,j};
			}
		}
		return null;
	}

}
