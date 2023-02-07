package org.howard.edu.hw2;

import java.util.LinkedHashMap;

public class FileReader {

    public static void main(String[] args) {
        FileReader fr = new FileReader();
        LinkedHashMap<String, Integer> my_map = new LinkedHashMap<String, Integer>(); //I decided to use a hash map because it is the most similar to a dictionary in python

        String file_string = fr.readToString("source/main/java/resources/words.txt"); //store the text from the file in a string
		String[] separated = file_string.toLowerCase().split(" "); //put each word into an array removing all punctuation and spaces
		for (int x = 0; x < separated.length; x++) {
		    if (separated[x].length() > 3) {
		        if (my_map.get(separated[x]) == null) { //if it is not in the hash map, add it and set its value to zero
		            my_map.put(separated[x], 1);
		        }
		        else { //if it is in the hash map increment its count
		            my_map.put(separated[x], my_map.get(separated[x]) + 1);
		        }
		    }
		}
		for (String i : my_map.keySet()) {
		    System.out.println(i + " " + my_map.get(i));
		}

    }

	String readToString(String string) {
		return null;
	}

}