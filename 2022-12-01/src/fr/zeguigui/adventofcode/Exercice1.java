package fr.zeguigui.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.System.*;

public class Exercice1 {

    public static void main(String[] args) {
        out.println("Lecture du fichier : " + args[0]);
        long maxCalories = -1;
        long currentCalories = 0;
        try (Scanner scanner = new Scanner(new File(args[0]))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.isEmpty()) {
                    currentCalories += Long.parseLong(line);
                } else {
                    if (currentCalories > maxCalories) {
                        maxCalories = currentCalories;
                    }
                    currentCalories = 0;
                }
            }

            // Ne pas oublier le dernier !
            if (currentCalories > maxCalories) {
                maxCalories = currentCalories;
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        System.out.println("Max calories : " + maxCalories);
    }
}
