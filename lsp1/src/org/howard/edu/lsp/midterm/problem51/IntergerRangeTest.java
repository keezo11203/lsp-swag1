package org.howard.edu.lsp.midterm.problem51;

import org.howard.edu.lsp.midterm.problem51.Range.EmptyRangeException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class IntegerRangeTest {

    private IntegerRange my_range;

    @BeforeEach
    void setUp() {
        my_range = new IntegerRange(0, 100);
    }

    @AfterEach
    void tearDown() {
        my_range = null;
    }

    @Test
    @DisplayName("Test for get_lower")
    void testGetLower() {
        assertEquals(0, my_range.get_lower());
    }

    @Test
    @DisplayName("Test for get_upper")
    void testGetUpper() {
        assertEquals(100, my_range.get_upper());
    }

    @Test
    @DisplayName("Test for contains")
    void testContains() {
        assertTrue(my_range.contains(56));
        assertFalse(my_range.contains(789));
        assertFalse(my_range.contains(-34));
        assertTrue(my_range.contains(100));
    }

    @Test
    @DisplayName("Test for overlaps")
    void testOverlaps() throws EmptyRangeException {
        IntegerRange your_range;

        your_range = new IntegerRange(50, 75);
        assertTrue(my_range.overlaps(your_range));
        assertTrue(your_range.overlaps(my_range));

        your_range = new IntegerRange(89, 143);
        assertTrue(my_range.overlaps(your_range));
        assertTrue(your_range.overlaps(my_range));

        your_range = new IntegerRange(-10, 5);
        assertTrue(my_range.overlaps(your_range));
        assertTrue(your_range.overlaps(my_range));

        your_range = new IntegerRange(101, 456);
        assertFalse(my_range.overlaps(your_range));
        assertFalse(your_range.overlaps(my_range));
    }

    @Test
    @DisplayName("Test for EmptyRangeException")
    void testOverlapsException() {
        IntegerRange your_range = null;

        assertThrows(EmptyRangeException.class, () -> my_range.overlaps(your_range));
    }

    @Test
    @DisplayName("Test for size")
    void testSize() {
        IntegerRange your_range;

        your_range = new IntegerRange(25, 50);
        assertEquals(25, your_range.size());

        your_range = new IntegerRange(78, 143);
        assertEquals(65, your_range.size());

        your_range = new IntegerRange(-10, 10);
        assertEquals(20, your_range.size());

        assertEquals(100, my_range.size());
    }

    @Nested
    @DisplayName("Parameterized tests for overlaps")
    class OverlapsParameterizedTests {

        @ParameterizedTest
        @DisplayName("Test overlapping ranges")
        @CsvSource({
                "50, 75",
                "89, 143",
                "-10, 5"
        })
        void testOverlappingRanges(int lower, int upper) throws EmptyRangeException {
            IntegerRange your_range = new IntegerRange(lower, upper);
            assertTrue(my_range.overlaps(your_range));
            assertTrue(your_range.overlaps(my_range));
        }

        @ParameterizedTest
        @DisplayName("Test non-overlapping ranges")
        @CsvSource({
                "0, 10, 5, 15, true",
                "5, 15, 0, 10, true",
                "0, 5, 5, 10, false",
                "5, 10, 0, 5, false",
                "0, 10, 10, 20, false",
                "10, 20, 0, 10, false"
                })
        
        void testOverlappingRanges(int lower1, int upper1, int lower2, int upper2, boolean expected) throws EmptyRangeException {
        	IntegerRange range1 = new IntegerRange(lower1, upper1);
        	IntegerRange range2 = new IntegerRange(lower2, upper2);
        	boolean actual = range1.overlaps(range2);
        	assertEquals(expected, actual);
        	}
        
        @Test
        @DisplayName("Test EmptyRangeException when comparing with null")
        void testEmptyRangeException() {
        IntegerRange range = new IntegerRange(0, 10);
        IntegerRange nullRange = null;
        assertThrows(EmptyRangeException.class, () -> range.overlaps(nullRange));
        }
        
    }
}
