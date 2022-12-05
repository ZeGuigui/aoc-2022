package fr.zeguigui.adventofcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntervalTest {

    @Test
    void pointInsideInterval() {
        Interval test = new Interval(2,10);
        assertTrue(test.pointInsideInterval(2));
        assertTrue(test.pointInsideInterval(5));
        assertTrue(test.pointInsideInterval(10));
        assertFalse(test.pointInsideInterval(1));
        assertFalse(test.pointInsideInterval(11));
    }

    @Test
    void fullyContains() {
        assertTrue(Interval.fullyContains(new Interval(2,4), new Interval(2,3)));
        assertTrue(Interval.fullyContains(new Interval(2,4), new Interval(3,3)));
        assertFalse(Interval.fullyContains(new Interval(2,4), new Interval(3,9)));
        assertFalse(Interval.fullyContains(new Interval(2,4), new Interval(1,3)));
        assertTrue(Interval.fullyContains(new Interval(2,4), new Interval(1,9)));
    }

    @Test
    void overlaps() {
        assertTrue(Interval.overlaps(new Interval(5,7), new Interval(7,9)));
        assertTrue(Interval.overlaps(new Interval(2,8), new Interval(3,7)));
        assertTrue(Interval.overlaps(new Interval(6,6), new Interval(4,6)));
        assertTrue(Interval.overlaps(new Interval(2,6), new Interval(4,8)));
        assertFalse(Interval.overlaps(new Interval(2,6), new Interval(7,8)));
        assertFalse(Interval.overlaps(new Interval(2,6), new Interval(1,1)));
    }
}