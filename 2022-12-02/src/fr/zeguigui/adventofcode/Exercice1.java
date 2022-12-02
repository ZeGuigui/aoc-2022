package fr.zeguigui.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static java.lang.System.*;
public class Exercice1 {

    public static final int ROCK = 1;
    public static final int PAPER = 2;
    public static final int SCISSORS = 3;
    public static final int LOSS = 0;
    public static final int DRAW = 3;
    public static final int WON = 6;

    public static int computeScore(int elf, int self) {
        if (elf == self) {
            // Draw
            return self + DRAW;
        }
        switch (elf) {
            case ROCK:
                return self + ((self == PAPER) ? WON : LOSS);
            case PAPER:
                return self + ((self == ROCK) ? LOSS : WON);
            case SCISSORS:
                return self + ((self == ROCK) ? WON : LOSS);
        }

        // Should never happen!
        throw new RuntimeException("Invalid input!");
    }

    public static void main(String[] args) {
        out.println("Lecture du fichier : " + args[0]);
        int score = 0;
        int elf;
        int self;

        try (Scanner scanner = new Scanner(new File(args[0]))) {

            while (scanner.hasNextLine()) {
                String[] strategy = scanner.nextLine().split(" ");
                elf = switch (strategy[0]) {
                    case "A" -> ROCK;
                    case "B" -> PAPER;
                    case "C" -> SCISSORS;
                    default -> throw new RuntimeException("Invalid input for elf: " + strategy[0]);
                };
                self = switch (strategy[1]) {
                    case "X" -> ROCK;
                    case "Y" -> PAPER;
                    case "Z" -> SCISSORS;
                    default -> throw new RuntimeException("Invalid input for self: " + strategy[1]);
                };
                score += computeScore(elf, self);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        out.println("Final score: " + score);
    }

}
