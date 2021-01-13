package ocp.chapiter09;

public interface Herbivore {
	public int eatPlants(int quantity);
}

interface Omnivore {
	public void eatPlants();
}

class Bear1 implements Herbivore, Omnivore {
	public int eatPlants(int quantity) {
		System.out.println("Eating plants: " + quantity);
		return quantity;
	}

	public void eatPlants() {
		System.out.println("Eating plants");
	}
}