package ocp.chapiter04;

public class OcpTest10 {

	public static void main(String[] args) {

		CLEANING: for(char stables = 'a'; stables <= 'd'; stables++) {
			for(int leopard = 1; leopard<4; leopard++) {
				if(stables=='b' || leopard==2) {
					continue CLEANING;
				}
				System.out.println("Cleaning: "+stables+","+leopard);
			}
		}
	
		    for(char stables = 'a'; stables <= 'd'; stables++) {
				for(int leopard = 1; leopard<4; leopard++) {
					if(stables=='b' || leopard==2) {
						continue;
					}
					System.out.println("Cleaning without label: "+stables+","+leopard);
				}
		}
	}

}
