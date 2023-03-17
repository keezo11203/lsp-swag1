package org.howard.edu.lsp.midterm.problem51;

public interface Range {
    
    public class EmptyRangeException extends Exception {
        private static final long serialVersionUID = 1L;

		public EmptyRangeException(String error) {
            super(error);
        }
    }
        
    public boolean contains(int value);
    
    public boolean overlaps(Range other) throws EmptyRangeException;
    
    public int size();
    
    public int get_upper();
    
    public int get_lower();
}

public class IntegerRange implements Range {
    private int lower;
    private int upper; 
    
    IntegerRange(int low, int up) {
        this.lower = low;
        this.upper = up;
    }
    
    public int get_lower() {
        return lower;
    }
    
    public int get_upper() {
        return upper;
    }
    
    public boolean contains(int value) {
        if (get_lower() <= value && value <= get_upper()) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean overlaps(Range other) throws EmptyRangeException {
        if (other == null) {
            throw new EmptyRangeException("The range is empty");
        }
        else {
            if (get_lower() >= other.get_lower() && (get_upper() <= other.get_upper() || get_upper() >= other.get_upper())) {
                if (get_lower() > other.get_upper()) {
                    return false;
                }
                return true;
            }
            else if (get_lower() <= other.get_lower() && (get_upper() <= other.get_upper() || get_upper() >= other.get_upper())) {
                if (other.get_lower() > get_upper()) {
                    return false;
                }
                return true;
            }
            else {
                return false;
            }
        }
    }
    
    public int size() {
        return get_upper() - get_lower();
    }
}
