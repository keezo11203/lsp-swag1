package org.howard.edu.hw4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntegerSet {
    private List<Integer> my_set;
    
    public IntegerSet() {
        my_set = new ArrayList<Integer>();
    }
    
    //making an exception that extends the  java Exception class
    public class IntegerSetException extends Exception {
        private static final long serialVersionUID = 1L;

		//constructor that prints out error by calling super()
        public IntegerSetException(String error) {
            super(error);
        }
    }
    
    //get method
    public List<Integer> get_set() {
        return my_set;
    }
    
    //set method
    public void set_set(List<Integer> new_set) {
        my_set = new_set;
    }
    
    //removes all values present in the ArrayList
    public void clear() {
        my_set.clear();
    }
    
    //returns the length of the ArrayList
    public int length() {
        return my_set.size();
    }
    
    //checks if a given IntegerSet has the same elements as its own
    public boolean equals(IntegerSet a) {
        if (my_set.size() != a.length()) {
            return false;
        }
        else {
            return my_set.containsAll(a.my_set);
        }
    }
    
    //checks if a given value is inside the set already
    public boolean contains(int value) {
        return my_set.contains(value);
    }
    
    //returns the largest number in the set or throws an error if the set is empty
    public int largest() throws IntegerSetException {
        if (my_set.isEmpty()) {
            throw new IntegerSetException("The Set is Empty.");
        }
        else {
            int max = my_set.get(0);
            for (int i = 0; i < my_set.size(); i++) {
                if (my_set.get(i) > max) {
                    max = my_set.get(i);
                }
            }
            return max;
        }
    }
    
    //returns the smallest number in the set or throws an error if the set is empty
    public int smallest() throws IntegerSetException {
        if (my_set.isEmpty()) {
            throw new IntegerSetException("The Set is Empty.");
        }
        else {
            int min = my_set.get(0);
            for (int i = 0; i < my_set.size(); i++) {
                if (my_set.get(i) < min) {
                    min = my_set.get(i);
                }
            }
            return min;
        }
    }
    
    // adds a given integer to the set and does nothing if the number is already in the set
    public void add(int item) {
        if (my_set.contains(item) == false) {
            my_set.add(item);
        }
    }
    
    // removes a given integer from the set and does nothing if it is inside the set already
    public void remove(int item) {
        if (my_set.contains(item) == true) {
            my_set.remove(my_set.indexOf(item));
        }
    }
    
    // adds the elements in set b to my_set
    public void union(IntegerSet b) {
        for (int i = 0; i < b.length(); i++) {
            if (my_set.contains(b.my_set.get(i)) == false) {
                my_set.add(b.my_set.get(i));
            }
        }
    }
    
    // reconfigures my_set to only include the elements present in both my_set and b
    public void intersect(IntegerSet b) {
        my_set.retainAll(b.my_set);
    }
    
 // prints out all the elements in the set in ascending order
    public void sort() {
        Collections.sort(my_set);
        System.out.println(my_set);
    }

    // returns the sum of all the elements in the set
    public int sum() {
        int sum = 0;
        for (int i = 0; i < my_set.size(); i++) {
            sum += my_set.get(i);
        }
        return sum;
    }

    // returns the average of all the elements in the set or throws an error if the set is empty
    public double average() throws IntegerSetException {
        if (my_set.isEmpty()) {
            throw new IntegerSetException("The Set is Empty.");
        }
        else {
            double sum = 0;
            for (int i = 0; i < my_set.size(); i++) {
                sum += my_set.get(i);
            }
            return sum/my_set.size();
        }
    }

    // returns the median of all the elements in the set or throws an error if the set is empty
    public double median() throws IntegerSetException {
        if (my_set.isEmpty()) {
            throw new IntegerSetException("The Set is Empty.");
        }
        else {
            Collections.sort(my_set);
            int middle = my_set.size()/2;
            if (my_set.size()%2 == 1) {
                return my_set.get(middle);
            }
            else {
                return (my_set.get(middle-1) + my_set.get(middle))/2.0;
            }
        }
    }

    // returns a new IntegerSet with the elements that appear in both this set and set b
    public IntegerSet getIntersection(IntegerSet b) {
        IntegerSet result = new IntegerSet();
        for (int i = 0; i < my_set.size(); i++) {
            if (b.contains(my_set.get(i))) {
                result.add(my_set.get(i));
            }
        }
        return result;
    }

    // returns a new IntegerSet with the elements that appear in either this set or set b
    public IntegerSet getUnion(IntegerSet b) {
        IntegerSet result = new IntegerSet();
        result.union(this);
        result.union(b);
        return result;
    }

    public String toString() {
        return my_set.toString();
    }

    // returns a new IntegerSet with the elements that appear in this set but not in set b
    public IntegerSet getDifference(IntegerSet b) {
        IntegerSet result = new IntegerSet();
        result.set_set(my_set);
        result.diff(b);
        return result;
    }

	public void diff(IntegerSet b) {
		// TODO Auto-generated method stub
		
	}
}