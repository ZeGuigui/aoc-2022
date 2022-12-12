package fr.zeguigui.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercice1 {

    public static void main(String[] args) {
        Cpu cpu = new Cpu(1);
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if ("noop".equals(line)) {
                    cpu.noop();
                } else {
                    String[] instructions = line.split(" ");
                    cpu.addX(Integer.valueOf(instructions[1], 10));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Signal strength: " + cpu.getSignalStrength());
        System.out.println(cpu.getCrt());
    }

}
