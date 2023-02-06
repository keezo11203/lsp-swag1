package org.howard.edu.hw2;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Driver {
    
    public static void main(String[] args) {
        FileReader fr = new FileReader();
        String input = "";
        try {
            input = fr.readToString("src/main/resources/words.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        
        Scanner scan = new Scanner(input);
        HashMap<String, Integer> words = new HashMap<String, Integer>();
        
        while (scan.hasNext()) {
            String word = scan.next().toLowerCase();
            if (!words.containsKey(word) && word.length() > 3) {
                words.put(word, 1);
            } else if (words.containsKey(word) && word.length() > 3) {
                words.put(word, words.get(word) + 1);
            }
        }
        
        scan.close();
        
        System.out.println("Word\t\tCount");
        System.out.println("-----------------------------");
        for (String w : words.keySet()) {
            System.out.println(w + "\t\t" + words.get(w));
        }
    }
}
