package fr.zeguigui.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Exercice1 {

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

            List<Directory> smallDirectories = Directory.filterDirectoryBySize(currentDirectory, 100000);
            System.out.println("Directories of max 100000 : " );

            long smallTotalSize = 0;
            for (Directory d : smallDirectories) {
                smallTotalSize += d.getTotalSize();
                System.out.println("\t" + d.getName() + "\t" + d.getTotalSize());
            }
            System.out.println("---------------------------");
            System.out.println("\tsum\t" + smallTotalSize);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Exception analyse ligne : '" + line + "'");
            e.printStackTrace();
        }
    }

}
