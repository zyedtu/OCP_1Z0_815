package ocp.chapiter10;

public class ExampleTricky {

	public static void main(String[] args) {
		ExampleTricky exce = new ExampleTricky();
		System.out.println(exce.exceptions());
	}
	
	public String exceptions() {
		String result = "";
		String v = null;
		try {
			try {
				result += "before_";
				v.length();
				result += "after_";
			} catch (NullPointerException e) {
				result += "catch_";
				throw new RuntimeException();
			} finally {
				result += "finally_";
				throw new Exception();
			}
		} catch (Exception e) {
			result += "done";
		}
		return result;
	}
}
