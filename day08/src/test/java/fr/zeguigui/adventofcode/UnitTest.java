package fr.zeguigui.adventofcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {

    @Test
    void isHigher() {
        List<Integer> treeHeights = new ArrayList<>(List.of(2,5));
        assertTrue(TreeGrid.isVisible(6, treeHeights));
        assertFalse(TreeGrid.isVisible(5, treeHeights));
        assertFalse(TreeGrid.isVisible(1, treeHeights));
    }

    @Test
    void isTreeVisible() {
        TreeGrid treeGrid = new TreeGrid();
        treeGrid.addRowOfTrees("30373");
        treeGrid.addRowOfTrees("25512");
        treeGrid.addRowOfTrees("65332");
        treeGrid.addRowOfTrees("33549");
        treeGrid.addRowOfTrees("35390");

        assertTrue(treeGrid.isTreeVisible(0,0));
        assertTrue(treeGrid.isTreeVisible(1,1));
        assertTrue(treeGrid.isTreeVisible(2,1));
        assertFalse(treeGrid.isTreeVisible(2,2));
        assertEquals(21, treeGrid.getNumberOfVisibleTree());

        TreeGrid treeGrid2 = new TreeGrid();
        treeGrid2.addRowOfTrees("313");
        treeGrid2.addRowOfTrees("525");
        treeGrid2.addRowOfTrees("363");
        assertTrue(treeGrid2.isTreeVisible(1,1));

        TreeGrid treeGrid3 = new TreeGrid();
        treeGrid3.addRowOfTrees("363");
        treeGrid3.addRowOfTrees("525");
        treeGrid3.addRowOfTrees("313");
        assertTrue(treeGrid3.isTreeVisible(1,1));

    }

    @Test
    void numberOfVisibleNeighbours() {
        assertEquals(1, TreeGrid.getNumberOfVisibleNeighbours(5, List.of(3)));
        assertEquals(1, TreeGrid.getNumberOfVisibleNeighbours(5, List.of(5, 2)));
        assertEquals(2, TreeGrid.getNumberOfVisibleNeighbours(5, List.of(1, 2)));
        assertEquals(2, TreeGrid.getNumberOfVisibleNeighbours(5, List.of(3, 5, 3)));
    }

    @Test
    void scenicScore() {
        TreeGrid treeGrid = new TreeGrid();
        treeGrid.addRowOfTrees("30373");
        treeGrid.addRowOfTrees("25512");
        treeGrid.addRowOfTrees("65332");
        treeGrid.addRowOfTrees("33549");
        treeGrid.addRowOfTrees("35390");
        assertEquals(4, treeGrid.getScenicScore(1,2));
        assertEquals(8, treeGrid.getScenicScore(3,2));
        assertEquals(8, treeGrid.getMaxScenicView());
    }

}