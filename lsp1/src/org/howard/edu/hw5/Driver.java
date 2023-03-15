package org.howard.edu.hw5;
import org.howard.edu.hw5.IntegerSet.IntegerSetException;

public class Driver {
    public static void main(String[] args) throws IntegerSetException {
        // Create two IntegerSets and add some elements
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.add(3);
        set2.add(4);
        set2.add(5);

        // Print out the sets
        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);

        // Test the various methods
        System.out.println("set1 contains 2: " + set1.contains(2));
        System.out.println("set1 contains 4: " + set1.contains(4));
        set1.union(set2);
        System.out.println("After union: " + set1);
        set1.intersect(set2);
        System.out.println("After intersection: " + set1);
        set1.diff(set2);
        System.out.println("After diff: " + set1);
        System.out.println("set1 equals set2: " + set1.equals(set2));
        System.out.println("set2 equals set2: " + set2.equals(set2));
        System.out.println("set1 largest element: " + set1.largest());
        System.out.println("set2 smallest element: " + set2.smallest());
    }
}
