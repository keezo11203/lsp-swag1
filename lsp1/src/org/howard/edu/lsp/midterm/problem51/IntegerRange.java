package org.howard.edu.lsp.midterm.problem51;

public class IntegerRange implements Range {
    private final int lower;
    private final int upper;

    public IntegerRange(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public int get_lower() {
        return lower;
    }

    public int get_upper() {
        return upper;
    }

    public boolean contains(int value) {
        return value >= lower && value <= upper;
    }

    public boolean overlaps(Range other) throws EmptyRangeException {
        if (other == null) {
            throw new EmptyRangeException("The range is empty");
        }

        return Math.max(lower, other.get_lower()) <= Math.min(upper, other.get_upper());
    }

    public int size() {
        return upper - lower;
    }
}
