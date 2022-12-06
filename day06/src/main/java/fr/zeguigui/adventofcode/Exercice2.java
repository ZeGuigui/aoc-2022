package fr.zeguigui.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Exercice2 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while (scanner.hasNextLine()) {
                System.out.println("Marker position: " + CommunicationSystem.findStartOfMessage(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
