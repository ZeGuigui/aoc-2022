package fr.zeguigui.adventofcode;

public class Interval {

    public final int beginning;
    public final int end;

    public Interval (String interval) {
        String[] boundaries = interval.split("-");
        this.beginning = Integer.parseInt(boundaries[0],10);
        this.end = Integer.parseInt(boundaries[1],10);
    }

    public Interval(int beginning, int end) {
        this.beginning = beginning;
        this.end = end;
    }

    public boolean pointInsideInterval(int point) {
        return (beginning <= point) && (point <= end);
    }

    public static boolean fullyContains(Interval i1, Interval i2) {
        if ((i1 == null) || (i2 == null)) {
            throw new RuntimeException("Interval not set");
        }
        return (i1.pointInsideInterval(i2.beginning) && i1.pointInsideInterval(i2.end)) ||
               (i2.pointInsideInterval(i1.beginning) && i2.pointInsideInterval(i1.end));
    }

    public static boolean overlaps(Interval i1, Interval i2) {
        if ((i1 == null) || (i2 == null)) {
            throw new RuntimeException("Interval not set");
        }
        return i1.pointInsideInterval(i2.beginning) || i1.pointInsideInterval(i2.end) ||
                i2.pointInsideInterval(i1.beginning) || i2.pointInsideInterval(i1.end);
    }

}
