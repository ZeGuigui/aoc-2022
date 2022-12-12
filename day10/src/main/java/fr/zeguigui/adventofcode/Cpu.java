package fr.zeguigui.adventofcode;

import java.util.ArrayList;
import java.util.List;

public class Cpu {

    private int registryX;

    // Store registry value at the beginning of the cycle.
    private List<Integer> registryHistory;

    public Cpu(int initialRegistryValue) {
        this.registryX = initialRegistryValue;
        this.registryHistory = new ArrayList<>();
        this.registryHistory.add(registryX);
    }

    public void noop() {
        this.registryHistory.add(registryX);
    }

    public void addX(int increment) {
        this.registryHistory.add(registryX);
        this.registryX += increment;
        this.registryHistory.add(registryX);
    }

    // Value during the cycle
    public int getHistory(int cycle) {
        return this.registryHistory.get(cycle - 1);
    }

    public int getSignalStrength() {
        int cycle = 20;
        int strength = 0;
        while (cycle < this.registryHistory.size()) {
            strength += cycle * this.getHistory(cycle);
            cycle += 40;
        }
        return strength;
    }

    public String getCrt() {
        StringBuilder builder = new StringBuilder();

        int cycle = 0;
        for (int row = 0; row < 6; row++) {
            for (int pixel = 0; pixel < 40; pixel++) {
                cycle++;
                int spritePosition = this.getHistory(cycle);
                if (Math.abs(spritePosition - pixel) < 2) {
                    builder.append("#");
                } else {
                    builder.append(" ");
                }
            }
            builder.append("\n");
        }

        return builder.toString();
    }

}
