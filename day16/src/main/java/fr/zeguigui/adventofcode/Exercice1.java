package fr.zeguigui.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercice1 {

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while (scanner.hasNextLine()) {
                input.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Create the valves
        Map<String, Valve> valves = new HashMap<>();
        Pattern inputPattern = Pattern.compile("Valve ([A-Z]+) has flow rate=([0-9]+);.*");
        for(String line : input) {
            Matcher m = inputPattern.matcher(line);
            if (m.matches()) {
                Valve v = new Valve(m.group(1), Integer.valueOf(m.group(2), 10));
                valves.put(m.group(1), v);
            }
        }

        // Add the tunnels
        Pattern tunnelPattern = Pattern.compile("Valve ([A-Z]*).*valves (([A-Z]+(, )?)+)");
        for (String line : input) {
            Matcher m = tunnelPattern.matcher(line);
            if (m.matches()) {
                Valve v = valves.get(m.group(1));
                String[] targets = m.group(2).split(", ");
                for (String t : targets) {
                    v.getTunnels().add(valves.get(t));
                }
            }
        }
        valves.values().forEach(v -> System.out.println(v));
    }

}
