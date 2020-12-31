package ocp.chapiter08;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LongTailAnimal {
	protected void chew(List<Object> input) {
		Collection<?> coll = new ArrayList<Double>();
		List<? extends Number> listNumber = new ArrayList<Long>();
		List<? super String> listString = new ArrayList<CharSequence>();
	}
	
}

class Anteater extends LongTailAnimal {
	protected void chew(ArrayList<Double> input) {}
}
