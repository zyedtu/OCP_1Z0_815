package ocp.chapiter10;

import java.io.IOException;

public class Zoo {
	public static void main(String[] args) {
		System.out.println(args[0]);
		System.out.println(args[1]);
	}
	
	void fall(int distance) throws IOException {
		try {
			if(distance > 10) {
				throw new IOException();
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
