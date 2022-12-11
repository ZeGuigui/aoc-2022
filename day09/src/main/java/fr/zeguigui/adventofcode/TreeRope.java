package fr.zeguigui.adventofcode;

import java.util.HashSet;
import java.util.Set;

// Can be replaced with TreeRope2(1)!
public class TreeRope {

    private Coordinate head;
    private Coordinate tail;


    // Remember the tail coordinates
    private Set<Coordinate> tailCoordinates = new HashSet<>();

    public TreeRope() {
        this.head = new Coordinate(0,0);
        this.tail = new Coordinate(0, 0);
        this.tailCoordinates.add(new Coordinate(0,0));
    }

    public int getNumberOfTailPositions() {
        return this.tailCoordinates.size();
    }

    public Coordinate getTailCoordinates() {
        return this.tail;
    }

    public void setHeadCoordinates(Coordinate head) {
        this.head = head;
        this.autoMoveTail();
    }

    private void autoMoveTail() {
        if (Coordinate.isAdjacent(head,tail)) {
            return;
        }

        int moveX = 0;
        int moveY = 0;

        if (head.x() != tail.x()) {
            moveX = tail.x() < head.x() ? 1 : -1;
        }
        if (head.y() != tail.y()) {
            moveY = tail.y() < head.y() ? 1 : -1;
        }

        this.setTailCoordinates(new Coordinate(tail.x() + moveX, tail.y() + moveY));
    }

    private void setTailCoordinates(Coordinate tail) {
        this.tail = tail;
        this.tailCoordinates.add(tail);
    }

    public void moveUp() {
        this.setHeadCoordinates(new Coordinate(head.x(), head.y() + 1));
    }

    public void moveLeft() {
        this.setHeadCoordinates(new Coordinate(head.x() - 1, head.y()));
    }

    public void moveRight() {
        this.setHeadCoordinates(new Coordinate(head.x() + 1, head.y()));
    }

    public void moveDown() {
        this.setHeadCoordinates(new Coordinate(head.x(), head.y() - 1));
    }

    public void moveUp(int numberOfMoves) {
        for (int i = 0; i < numberOfMoves; i++) {
            this.moveUp();
        }
    }

    public void moveDown(int numberOfMoves) {
        for (int i = 0; i < numberOfMoves; i++) {
            this.moveDown();
        }
    }

    public void moveLeft(int numberOfMoves) {
        for (int i = 0; i < numberOfMoves; i++) {
            this.moveLeft();
        }
    }

    public void moveRight(int numberOfMoves) {
        for (int i = 0; i < numberOfMoves; i++) {
            this.moveRight();
        }
    }
}
