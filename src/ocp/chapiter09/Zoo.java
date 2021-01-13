package ocp.chapiter09;

import java.util.Collections;
import java.util.List;

public class Zoo {
	public void sortAndPrintZooAnimals(List<String> animals) {
		Collections.sort(animals);
		for(String a : animals) {
			System.out.println(a);
		}
	}
}
