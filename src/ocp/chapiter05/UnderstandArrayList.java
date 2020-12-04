package ocp.chapiter05;

import java.util.ArrayList;
import java.util.List;
public class UnderstandArrayList {

	public static void main(String[] args) {
		
		ArrayList list1 = new ArrayList();
		ArrayList list2 = new ArrayList(10);
		ArrayList list3 = new ArrayList(list2);
		
		ArrayList<String> listJava5 = new ArrayList<String>();
		ArrayList<String> listJava7 = new ArrayList<>();
		
		var listStr = new ArrayList<String>();
		listStr.add("a");
		for(String s : listStr) {}
		
		var listGen = new ArrayList<>();
		listGen.add("a");
		// for(String s : listGen) {} // DOES NOT COMPILE
		System.out.println("---------------------------------------------------");
		
		List<String> birds = new ArrayList<>();
		birds.add("hawk"); // [hawk]
		birds.add(1, "robin"); // [hawk, robin]
		birds.add(0, "blue jay"); // [blue jay, hawk, robin]
		birds.add(1, "cardinal"); // [blue jay, cardinal, hawk, robin]
		System.out.println(birds); // [blue jay, cardinal, hawk, robin]
		
		System.out.println("------------------------------------------");
		List<String> birds2 = new ArrayList<>();
		birds2.add("hawk"); // [hawk]
		birds2.add("hawk"); // [hawk, hawk]
		System.out.println(birds2.remove("cardinal")); // prints false
		System.out.println(birds2.remove("hawk")); // prints true
		System.out.println(birds2.remove(0)); // prints hawk
		System.out.println(birds2); // []
		System.out.println("------------------------------------------");
		ArrayList<String> arr = new ArrayList<>();
		arr.add("a");
		arr.add("b");
		arr.add("c");
		System.out.println(arr.get(1));	// b
		System.out.println("---------------------------------------------------");
		List<String> birds3 = new ArrayList<>();
		birds3.add("hawk"); // [hawk]
		System.out.println(birds3.size()); // 1
		birds3.set(0, "robin"); // [robin]
		System.out.println(birds3.size()); // 1
		//birds3.set(1, "robin"); // IndexOutOfBoundsException
		System.out.println("------------------------------------------");
		List<String> birds4 = new ArrayList<>();
		System.out.println(birds4.isEmpty()); // true
		System.out.println(birds4.size()); // 0
		birds4.add("hawk"); // [hawk]
		birds4.add("hawk");	// [hawk, hawk]
		System.out.println(birds.isEmpty()); // false
		System.out.println(birds.size()); // 2
		System.out.println("------------------------------------------");
		List<String> one = new ArrayList<>();
		List<String> two = new ArrayList<>();
		System.out.println(one.equals(two)); // true
		one.add("a"); // [a]
		System.out.println(one.equals(two)); // false
		two.add("a"); // [a]
		System.out.println(one.equals(two)); // true
		one.add("b"); // [a,b]
		two.add(0, "b"); // [b,a]
		System.out.println(one.equals(two)); // false
		System.out.println("----------------NoString-------------------------");
		NoString noString1 = new NoString(1);
		NoString noString2 = new NoString(1);
		List<NoString> listNoString1 = new ArrayList<NoString>();
		List<NoString> listNoString2 = new ArrayList<NoString>();
		System.out.println(listNoString1.equals(listNoString2));
		listNoString1.add(noString1);
		listNoString2.add(noString2);
		System.out.println(listNoString1.equals(listNoString2));
		
				
	}

}

class NoString{
	int i;
	public NoString(int i) {
		this.i = i;
	}
}