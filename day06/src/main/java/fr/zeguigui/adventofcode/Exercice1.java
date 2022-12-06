package fr.zeguigui.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercice1 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while (scanner.hasNextLine()) {
                System.out.println("Marker position: " + CommunicationSystem.findPosition(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
