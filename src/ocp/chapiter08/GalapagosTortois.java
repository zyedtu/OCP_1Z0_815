package ocp.chapiter08;

import java.io.FileNotFoundException;
import java.io.IOException;

class Reptile {
	protected void sleepInShell() throws IOException {}
	protected void hideInShell() throws NumberFormatException {}
	protected void exitShell() throws FileNotFoundException {}
}

public class GalapagosTortois extends Reptile{
	public void sleepInShell() throws FileNotFoundException {}
	public void hideInShell() throws IllegalArgumentException  {}
//	public void exitShell() throws IOException {}	// DOES NOT COMPILE
}
