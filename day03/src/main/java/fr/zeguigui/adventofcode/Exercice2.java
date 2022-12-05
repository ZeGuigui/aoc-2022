package fr.zeguigui.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercice2 {

    public static int getPriority(char item) {

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

    public static char getCommonItem(String s1, String s2, String s3) {
        int[][] itemCount = new int[3]['z' + 1];
        for (int i = 0; i <= 'Z'; i++) {
            itemCount[0][i] = 0;
            itemCount[1][i] = 0;
            itemCount[2][i] = 0;
        }
        for (int i = 0; i < s1.length(); i++) {
            itemCount[0][s1.charAt(i)]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            itemCount[1][s2.charAt(i)]++;
        }
        for (int i = 0; i < s3.length(); i++) {
            itemCount[2][s3.charAt(i)]++;
        }
        for (int i = 'A'; i <= 'z'; i++) {
            if ((itemCount[0][i] > 0) && (itemCount[1][i] > 0) && (itemCount[2][i] > 0)) {
                return (char)i;
            }
        }
        return '\u0000';
    }

    public static void main(String[] args) {
        int sumOfPriorities = 0;
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while (scanner.hasNextLine()) {
                String rucksack1 = scanner.nextLine();
                String rucksack2 = scanner.nextLine();
                String rucksack3 = scanner.nextLine();
                sumOfPriorities += getPriority(getCommonItem(rucksack1, rucksack2, rucksack3));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Sum of priorities: "  + sumOfPriorities);
    }
}
