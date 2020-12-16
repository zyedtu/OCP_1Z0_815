package ocp.chapiter07.pond.goose;

import ocp.chapiter07.pond.shore.Bird;

public class Gosling extends Bird {
	public void swim() {
		floatInWater(); // calling protected member
		System.out.println(text); // calling protected member
	}
}
