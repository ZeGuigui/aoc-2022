package fr.zeguigui.adventofcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CargoTest {

    @Test
    void getTopItems() {
        Cargo cargo = new Cargo();
        // Line 1
        cargo.addToStack(2, "D");
        // Line 2
        cargo.addToStack(1, "N");
        cargo.addToStack(2, "C");
        // Line 3
        cargo.addToStack(1, "Z");
        cargo.addToStack(2, "M");
        cargo.addToStack(3, "P");

        // I like to move it, move it!
        cargo.move(1, 2, 1, false);
        assertEquals("DCP", cargo.getTopItems());
        cargo.move(3, 1, 3, false);
        assertEquals("CZ", cargo.getTopItems());
        cargo.move(2, 2, 1, false);
        assertEquals("MZ", cargo.getTopItems());
        cargo.move(1, 1, 2, false);
        assertEquals("CMZ", cargo.getTopItems());
    }

    @Test
    void testMoveItems2() {
        Cargo cargo = new Cargo();
        // Line 1
        cargo.addToStack(2, "D");
        // Line 2
        cargo.addToStack(1, "N");
        cargo.addToStack(2, "C");
        // Line 3
        cargo.addToStack(1, "Z");
        cargo.addToStack(2, "M");
        cargo.addToStack(3, "P");

        // I like to move it, move it!
        cargo.move(1, 2, 1, true);
        assertEquals("DCP", cargo.getTopItems());
        cargo.move(3, 1, 3, true);
        assertEquals("CD", cargo.getTopItems());
        cargo.move(2, 2, 1, true);
        assertEquals("CD", cargo.getTopItems());
        cargo.move(1, 1, 2, true);
        assertEquals("MCD", cargo.getTopItems());
    }

    @Test
    void parseStackLine() {
        Cargo cargo = new Cargo();
        cargo.parseStackLine("    [D]    ");
        assertEquals("D", cargo.getTopItems());
        cargo.parseStackLine("[N] [C]    ");
        assertEquals("ND", cargo.getTopItems());
        cargo.parseStackLine("[Z] [M] [P]");
        assertEquals("NDP", cargo.getTopItems());
    }

    @Test
    void testParseMoveLine() {
        Cargo cargo = new Cargo();
        // Line 1
        cargo.addToStack(2, "D");
        // Line 2
        cargo.addToStack(1, "N");
        cargo.addToStack(2, "C");
        // Line 3
        cargo.addToStack(1, "Z");
        cargo.addToStack(2, "M");
        cargo.addToStack(3, "P");

        cargo.parseMoveLine("move 1 from 2 to 1", false);
        assertEquals("DCP", cargo.getTopItems());
        cargo.parseMoveLine("move 3 from 1 to 3", false);
        assertEquals("CZ", cargo.getTopItems());
        cargo.parseMoveLine("move 2 from 2 to 1", false);
        assertEquals("MZ", cargo.getTopItems());
        cargo.parseMoveLine("move 1 from 1 to 2", false);
        assertEquals("CMZ", cargo.getTopItems());
    }

}