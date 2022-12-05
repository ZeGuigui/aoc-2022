package fr.zeguigui.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercice1 {

    public static char findItem(String rucksack) {
        int len = rucksack.length();
        for (int i = 0; i < len / 2; i++) {
            for (int j = len / 2; j < len; j++) {
                if (rucksack.charAt(i) == rucksack.charAt(j)) {
                    return rucksack.charAt(i);
                }
            }
        }
        return '\u0000';
    }

    public static int getPriority(String rucksack) {

        char item = findItem(rucksack);
        if (item == '\u0000') {
            throw new RuntimeException("Invalid rucksack!");
        }

        // ascii : A < a
        if (item >= 'a') {
            return item - 'a' + 1;
        } else {
            return item - 'A' + 27;
        }
    }


    public static void main(String[] args) {
        int sumOfPriorities = 0;
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while (scanner.hasNextLine()) {
                String rucksack = scanner.nextLine();
                if (!rucksack.isEmpty()) {
                    sumOfPriorities += getPriority(rucksack);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Sum of priorities: "  + sumOfPriorities);
    }

}
