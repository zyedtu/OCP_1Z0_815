package ocp.chapiter02;

public class OcpTest1 {
	
	private String name = "fluffy";
	
	{System.out.println("setting field " + name);}
	
	public OcpTest1() {
		name = "Tiny";
		System.out.println("setting constructor");
	}

	public static void main(String[] args) {

		OcpTest1 ocpTest1 = new OcpTest1();
		System.out.println(ocpTest1.name);
	}

}
