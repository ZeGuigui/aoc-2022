package fr.zeguigui.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercice2 {

    public static void main(String[] args) {

        Cargo cargo = new Cargo(50);

        try (Scanner scanner = new Scanner(new File(args[0]))) {

            boolean adding = true;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.isEmpty()) {
                    adding = false;
                    cargo.printCargo();
                }

                if (adding) {
                    cargo.parseStackLine(line);
                } else {
                    cargo.parseMoveLine(line, true);
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(cargo.getTopItems());
    }

}
