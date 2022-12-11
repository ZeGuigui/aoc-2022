package fr.zeguigui.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercice1 {

    public static void main(String[] args) {
        TreeRope treeRope = new TreeRope();
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(" ", 2);
                int numberOfMoves = Integer.valueOf(line[1], 10);
                switch (line[0]) {
                    case "U" -> treeRope.moveUp(numberOfMoves);
                    case "D" -> treeRope.moveDown(numberOfMoves);
                    case "L" -> treeRope.moveLeft(numberOfMoves);
                    case "R" -> treeRope.moveRight(numberOfMoves);
                    default -> throw new RuntimeException("Invalid input");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Number of tail positions: " + treeRope.getNumberOfTailPositions());
    }

}
