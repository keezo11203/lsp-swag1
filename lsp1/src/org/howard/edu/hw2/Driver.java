package org.howard.edu.hw2;

public class Driver {

	public static void main(String[] args) {
		FileReader fr = new FileReader();
		System.out.println(fr.readToString("main/java/resources/words.txt"));
	}
}
