package ocp.chapiter10;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class FinallyClosingResources {
	
	public void readFile(String file) {
		try(FileInputStream is = new FileInputStream("myFile.txt");
				FileOutputStream out = new FileOutputStream("output.txt")){
			// Read file date
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		FileInputStream is = null;
		try {
			is = new FileInputStream("myFile.txt");
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(is != null) {
				try {
					is.close();
				}catch(IOException e2) {
					e2.printStackTrace();
				}
			}
		}
		try(FileInputStream in = new FileInputStream("input.txt");
				FileOutputStream out = new FileOutputStream("output.txt");){
			// Protected code
		}catch(IOException e) {
			// Exception handler
		}finally {
			// finally block
		}
		
	}

}
