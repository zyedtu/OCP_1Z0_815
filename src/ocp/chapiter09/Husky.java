package ocp.chapiter09;

public abstract class Husky {
	abstract void play();
}

interface Poodle {
	void play();
}


class Webby extends Husky {
	void play() {}
}

class Georgette implements Poodle {
	public void play() {}
}

interface Ter {
	private void e() {

	}
}