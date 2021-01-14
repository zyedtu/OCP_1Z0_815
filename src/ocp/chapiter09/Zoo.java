package ocp.chapiter09;

public class Zoo {
	private interface Paper {
		String getId();
	}
	public class Ticket implements Paper {
		private String serialNumber;
		public String getId() { return serialNumber;}
	}
	
	public Ticket sellTicket(String serialNumber) {
		var t = new Ticket();
		t.serialNumber = serialNumber;
		return t;
	}
	
	public static void main(String... unsuse) {
		var z = new Zoo();
		var t = z.sellTicket("12345");
		System.out.println(t.getId()+" Ticket sold!");
	}
}
