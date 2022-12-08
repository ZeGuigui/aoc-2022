package fr.zeguigui.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercice1 {

    public static void main(String[] args) {
        TreeGrid treeGrid = new TreeGrid();

        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while (scanner.hasNextLine()) {
                treeGrid.addRowOfTrees(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(treeGrid.getNumberOfVisibleTree());
    }

}
