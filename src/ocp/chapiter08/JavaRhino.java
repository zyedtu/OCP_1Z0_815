package ocp.chapiter08;

class Rhino {
	protected CharSequence getName() {
		return "rhino";
	}
	protected String getColor() {
		return "grey, black, or white";
	}
}
public class JavaRhino extends Rhino {
	protected String getName() {
		return "rhino";
	}
//	protected CharSequence getColor() {	// DEOS NOT COMPILE
//		return "grey, black, or white";
//	}
}
