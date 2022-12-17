package fr.zeguigui.adventofcode;

import java.util.ArrayList;
import java.util.List;

public class Valve {

    private final String name;
    private final int flowRate;
    private final List<Valve> tunnels = new ArrayList<>();
    private boolean open;

    public Valve(String name, int flowRate) {
        this.name = name;
        this.flowRate = flowRate;
    }

    public List<Valve> getTunnels() {
        return this.tunnels;
    }

    public boolean isOpened() {
        return this.open;
    }

    public int getFlowRate() {
        return this.flowRate;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        String result = "Valve " + name + " has flow rate=" + flowRate + "; tunnels lead to valves ";
        for (Valve t : this.tunnels) {
            result += t.name + " ";
        }
        return result;
    }
}
