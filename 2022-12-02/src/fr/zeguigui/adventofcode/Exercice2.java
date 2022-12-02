package fr.zeguigui.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static java.lang.System.out;

public class Exercice2 {

    public static final int ROCK = 1;
    public static final int PAPER = 2;
    public static final int SCISSORS = 3;
    public static final int LOSS = 0;
    public static final int DRAW = 3;
    public static final int WON = 6;

    public static int computeScore(int elf, int outcome) {
        if (outcome == DRAW) {
            // Draw
            return elf + DRAW;
        }
        return switch (elf) {
            case ROCK     -> outcome + ((outcome == WON) ? PAPER : SCISSORS );
            case PAPER    -> outcome + ((outcome == WON) ? SCISSORS : ROCK );
            case SCISSORS -> outcome + ((outcome == WON) ? ROCK : PAPER );
            default -> throw new RuntimeException("Invalid input!");
        };
    }

    public static void main(String[] args) {
        out.println("Lecture du fichier : " + args[0]);
        int score = 0;
        int elf;
        int outcome;

        try (Scanner scanner = new Scanner(new File(args[0]))) {

            while (scanner.hasNextLine()) {
                String[] strategy = scanner.nextLine().split(" ");
                elf = switch (strategy[0]) {
                    case "A" -> ROCK;
                    case "B" -> PAPER;
                    case "C" -> SCISSORS;
                    default -> throw new RuntimeException("Invalid input for elf: " + strategy[0]);
                };
                outcome = switch (strategy[1]) {
                    case "X" -> LOSS;
                    case "Y" -> DRAW;
                    case "Z" -> WON;
                    default -> throw new RuntimeException("Invalid input for self: " + strategy[1]);
                };
                score += computeScore(elf, outcome);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        out.println("Final score: " + score);
    }

}
