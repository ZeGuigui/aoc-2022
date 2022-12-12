package fr.zeguigui.adventofcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {

    @Test
    void test() {

        Hill hill = new Hill(8,5);
        List<String> heatmap = Arrays.asList("Sabqponm", "abcryxxl", "accszExk", "acctuvwj", "abdefghi");
        hill.parseHeatmap(heatmap);
        assertEquals(new Point(0,0), hill.getStart());
        assertEquals(new Point(5,2), hill.getEnd());
        assertEquals(31, hill.computeShortestPathLength());
    }

}