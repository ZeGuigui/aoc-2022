package fr.zeguigui.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.out;

public class Exercice2 {

    public static void main(String[] args) {
        out.println("Lecture du fichier : " + args[0]);
        List<Long> calories = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(args[0]))) {
            long currentCalories = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.isEmpty()) {
                    currentCalories += Long.parseLong(line);
                } else {
                    calories.add(currentCalories);
                    currentCalories = 0;
                }
            }

            // Ne pas oublier le dernier !
            if (currentCalories != 0) {
                calories.add(currentCalories);
            }

            calories.sort(Collections.reverseOrder());
            out.println(calories.get(0) + calories.get(1) + calories.get(2));

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
