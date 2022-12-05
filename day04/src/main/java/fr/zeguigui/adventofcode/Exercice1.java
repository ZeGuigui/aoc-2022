package fr.zeguigui.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercice1 {

    public static void main(String[] args) {
        int fullyContains = 0;
        int lines = 0;

        try (Scanner scanner = new Scanner(new File(args[0]))) {

            while (scanner.hasNextLine()) {
                lines++;
                String line = scanner.nextLine();
                String[] intervals = line.split(",");
                if (Interval.fullyContains(new Interval(intervals[0]), new Interval(intervals[1]))) {
                    fullyContains++;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Fully contains: " + fullyContains + " in " + lines + " lines");
    }

}
