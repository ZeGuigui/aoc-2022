package fr.zeguigui.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercice1 {

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while (scanner.hasNextLine()) {
                input.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Hill hill = new Hill( input.get(0).length(), input.size() );
        hill.parseHeatmap(input);
        System.out.println("From " + hill.getStart() + " to " + hill.getEnd());
        System.out.println("Shortest path length: " + hill.computeShortestPathLength());
    }

}
