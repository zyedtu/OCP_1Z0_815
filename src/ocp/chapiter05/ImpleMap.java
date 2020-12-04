package ocp.chapiter05;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ImpleMap {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<>();
		map.put("koala", "bamboo");
		map.put("bird", "tree");
		System.out.println(map.get("koala"));	// bamboo
		System.out.println(map.getOrDefault("ant", "leaf"));	// leaf
		System.out.println(map.getOrDefault("bird", "leaf"));	// tree
		System.out.println(map.containsKey("koala"));	// true
		System.out.println(map.containsValue("tree"));	// true
		Collection<String> values = map.values();
		System.out.println(values);	//	[bamboo, tree]
		String rmv = map.remove("bird");
		System.out.println(rmv);	// tree
		for(String key: map.keySet())
			System.out.println(map.get(key));	// bamboo
	}

}
