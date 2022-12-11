package fr.zeguigui.adventofcode;

import java.util.HashSet;
import java.util.Set;

public class TreeRope2 {

    private Coordinate[] knots;

    // Remember the tail coordinates
    private Set<Coordinate> tailCoordinates = new HashSet<>();

    public TreeRope2(int nbKnots) {
        Coordinate zero = new Coordinate(0,0);
        this.knots = new Coordinate[nbKnots];
        for (int i = 0; i < nbKnots; i++) {
            this.knots[i] = zero;
        }
        this.tailCoordinates.add(zero);
    }

    public int getNumberOfTailPositions() {
        return this.tailCoordinates.size();
    }

    public void setHeadCoordinates(Coordinate head) {
        this.knots[0] = head;
        this.autoMove();
    }

    private void autoMove() {
        for (int i = 1; i < this.knots.length; i++) {
            this.knots[i] = movePoint(this.knots[i-1], this.knots[i]);
        }
        this.tailCoordinates.add(this.knots[this.knots.length - 1]);
    }

    private static Coordinate movePoint(Coordinate previousKnot, Coordinate knot) {
        if (Coordinate.isAdjacent(previousKnot,knot)) {
            return knot;
        }

        int moveX = 0;
        int moveY = 0;

        if (previousKnot.x() != knot.x()) {
            moveX = knot.x() < previousKnot.x() ? 1 : -1;
        }
        if (previousKnot.y() != knot.y()) {
            moveY = knot.y() < previousKnot.y() ? 1 : -1;
        }

        return new Coordinate(knot.x() + moveX, knot.y() + moveY);
    }

    public void moveUp() {
        this.setHeadCoordinates(new Coordinate(knots[0].x(), knots[0].y() + 1));
    }

    public void moveLeft() {
        this.setHeadCoordinates(new Coordinate(knots[0].x() - 1, knots[0].y()));
    }

    public void moveRight() {
        this.setHeadCoordinates(new Coordinate(knots[0].x() + 1, knots[0].y()));
    }

    public void moveDown() {
        this.setHeadCoordinates(new Coordinate(knots[0].x(), knots[0].y() - 1));
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
