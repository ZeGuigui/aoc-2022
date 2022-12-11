package fr.zeguigui.adventofcode;

public record Coordinate(int x, int y) {

    /*
     * Distance between 2 points is d² = (xB - xA)² + (yB - yA)²
     */
    public static double distance2(Coordinate pointA, Coordinate pointB) {
        return Math.pow(pointA.x() - pointB.x(), 2) + Math.pow(pointA.y() - pointB.y(), 2);
    }

    public static boolean isAdjacent(Coordinate pointA, Coordinate pointB) {
        // max d² for adjacent points is 2
        return distance2(pointA, pointB) < 4;
    }

}
