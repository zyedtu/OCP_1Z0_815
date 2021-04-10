package ocp.chapiter10;

public class UsingTryCatch {
	public static void main(String[] args) {
		String s = "";
		try {
			s += "t";
		} catch (Exception e) {
			s += "c";
		} finally {
			s += "f";
		}
		s += "a";
		System.out.print(s);
		
		System.out.println("");
		System.out.println(" goHome(): " + new UsingTryCatch().goHome());
	}
	
	int goHome() {
		try {
			System.out.print("1");
			return -1;
		}catch(Exception e) {
			System.out.print("2");
			return -2;
		}finally {
			System.out.print("3");
		}
	}
	
	
}
