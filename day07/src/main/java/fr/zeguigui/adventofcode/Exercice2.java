package fr.zeguigui.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Exercice2 {

    public static void main(String[] args) {

        Directory currentDirectory = new Directory("/", null);
        String line = "";

        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                currentDirectory = currentDirectory.parseLine(line);
            }

            currentDirectory = currentDirectory.parseLine("$ cd /");
            System.out.println("Total size of root Directory: " + currentDirectory.getTotalSize());
            long deviceCapacity = 70000000;
            long minFreespace = 30000000;
            long initialFreespace = deviceCapacity - currentDirectory.getTotalSize();
            long neededSize = minFreespace - initialFreespace;

            System.out.println("Initial freespace : " + initialFreespace);
            System.out.println("Needed size : " + neededSize);

            Directory dirToDelete = Directory.filterDirectoryByMinSize(currentDirectory, neededSize).stream().min(Comparator.comparingLong(Directory::getTotalSize)).orElse(currentDirectory);

            Directory.filterDirectoryByMinSize(currentDirectory, neededSize).stream().sorted(Comparator.comparingLong(Directory::getTotalSize)).forEach(d -> System.out.println(d.getName() + " -> " + d.getTotalSize()));

            System.out.println("Directory to remove : " + dirToDelete.getName() + " : " + dirToDelete.getTotalSize());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Exception analyse ligne : '" + line + "'");
            e.printStackTrace();
        }
    }

}
