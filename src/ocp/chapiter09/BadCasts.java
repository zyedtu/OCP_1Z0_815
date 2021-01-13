package ocp.chapiter09;


interface Canine { }
class Dog implements Canine { }
class Wolf implements Canine { }

class BadCasts {
	public static void main(String [] args) {
		Canine canine = new Wolf();
		Canine badDog = (Dog) canine;
	}
}