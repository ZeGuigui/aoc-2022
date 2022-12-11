package fr.zeguigui.adventofcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UnitTest {

    @Test
    void testAutoMove1() {
        TreeRope treeRope = new TreeRope();
        treeRope.setHeadCoordinates(new Coordinate(2,0));
        assertEquals(new Coordinate(1,0), treeRope.getTailCoordinates());

        treeRope = new TreeRope();
        treeRope.setHeadCoordinates(new Coordinate(-2,0));
        assertEquals(new Coordinate(-1,0), treeRope.getTailCoordinates());

        treeRope = new TreeRope();
        treeRope.setHeadCoordinates(new Coordinate(0,2));
        assertEquals(new Coordinate(0,1), treeRope.getTailCoordinates());

        treeRope = new TreeRope();
        treeRope.setHeadCoordinates(new Coordinate(0,-2));
        assertEquals(new Coordinate(0,-1), treeRope.getTailCoordinates());

        treeRope = new TreeRope();
        treeRope.setHeadCoordinates(new Coordinate(1,1));
        assertEquals(new Coordinate(0,0), treeRope.getTailCoordinates());

        treeRope = new TreeRope();
        treeRope.setHeadCoordinates(new Coordinate(1,2));
        assertEquals(new Coordinate(1,1), treeRope.getTailCoordinates());

        treeRope = new TreeRope();
        treeRope.setHeadCoordinates(new Coordinate(-1,2));
        assertEquals(new Coordinate(-1,1), treeRope.getTailCoordinates());

        treeRope = new TreeRope();
        treeRope.setHeadCoordinates(new Coordinate(-1,-2));
        assertEquals(new Coordinate(-1,-1), treeRope.getTailCoordinates());

        treeRope = new TreeRope();
        treeRope.setHeadCoordinates(new Coordinate(1,-2));
        assertEquals(new Coordinate(1,-1), treeRope.getTailCoordinates());
    }

    @Test
    void testCountMove() {
        TreeRope treeRope = new TreeRope();
        treeRope.moveRight(4);
        treeRope.moveUp(4);
        treeRope.moveLeft(3);
        treeRope.moveDown(1);
        treeRope.moveRight(4);
        treeRope.moveDown(1);
        treeRope.moveLeft(5);
        treeRope.moveRight(2);
        assertEquals(13, treeRope.getNumberOfTailPositions());
    }

    @Test
    void testNewRope() {
        TreeRope2 treeRope = new TreeRope2(10);
        treeRope.moveRight(5);
        treeRope.moveUp(8);
        treeRope.moveLeft(8);
        treeRope.moveDown(3);
        treeRope.moveRight(17);
        treeRope.moveDown(10);
        treeRope.moveLeft(25);
        treeRope.moveUp(20);
        assertEquals(36, treeRope.getNumberOfTailPositions());
    }

}