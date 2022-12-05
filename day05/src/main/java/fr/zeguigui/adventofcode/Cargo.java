package fr.zeguigui.adventofcode;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cargo {

    private final ArrayList<ArrayList<String>> stacks = new ArrayList<>();
    private static final Pattern movePattern = Pattern.compile("move (\\d+) from (\\d+) to (\\d+)");
    private static final Pattern stackPattern = Pattern.compile("(\s{3}|\\[([a-zA-Z]+)])\\s?");

    public Cargo() {
        this(10);
    }

    public Cargo(int maxStacks) {
        for (int i = 0; i < maxStacks; i++) {
            stacks.add(new ArrayList<>());
        }
    }

    public void printCargo() {
        for (int i = 1; i <= 9; i++) {
            System.out.print (i + " : ");
            stacks.get(i).forEach(item -> System.out.print("[" + item + "] "));
            System.out.println();
        }
    }

    public void parseStackLine(String line) {
        Matcher matcher = stackPattern.matcher(line);
        int i = 1;
        while (matcher.find()) {
            if (matcher.group(2) != null) {
                this.addToStack(i, matcher.group(2));
            }
            i++;
        }
    }

    public void parseMoveLine(String line, boolean exercice2) {
        if (line.startsWith("move")) {
            Matcher m = movePattern.matcher(line);
            if (m.find()) {
                int nb = Integer.parseInt(m.group(1), 10);
                int from = Integer.parseInt(m.group(2), 10);
                int to = Integer.parseInt(m.group(3), 10);
                this.move(nb, from, to, exercice2);
            } else {
                throw new RuntimeException("Invalid move line");
            }
        }
    }

    public void addToStack(int stack, String element) {
        stacks.get(stack).add(0, element);
    }

    public void move(int nb, int from, int to, boolean exercice2) {
        if (!exercice2) {
            for (int i = 0; i < nb; i++) {
                if (!stacks.get(from).isEmpty()) {
                    stacks.get(to).add(stacks.get(from).get(stacks.get(from).size() - 1));
                    stacks.get(from).remove(stacks.get(from).size() - 1);
                }
            }
        } else {
            stacks.get(to).addAll(stacks.get(from).subList(stacks.get(from).size() - nb, stacks.get(from).size()));
            for (int i = 0; i < nb; i++) {
                stacks.get(from).remove(stacks.get(from).size() - 1);
            }
        }
    }

    public String getTopItems() {
        StringBuilder result = new StringBuilder("");
        for (ArrayList<String> stack : stacks) {
            if (!stack.isEmpty()) {
                result.append(stack.get(stack.size() - 1));
            }
        }
        return result.toString();
    }

}
