package org.howard.edu.hw2;

import java.io.FileNotFoundException;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException {
		FileReader fr = new FileReader();
		System.out.println(fr.readToString("main/java/resources/words.txt"));
	}
}