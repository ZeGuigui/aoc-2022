package fr.zeguigui.adventofcode;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public record Point(int x, int y) {

    public static int getAltitude(char altitude) {
        return switch(altitude) {
            case 'S' -> 0;
            case 'E' -> 25;
            default -> altitude - 'a';
        };
    }

    @Contract(" -> new")
    public @NotNull Point upper() {
        return new Point(x, y - 1);
    }

    @Contract(" -> new")
    public @NotNull Point left() {
        return new Point(x-1, y);
    }

    @Contract(" -> new")
    public @NotNull Point right() {
        return new Point(x+1, y);
    }

    @Contract(" -> new")
    public @NotNull Point down() {
        return new Point(x, y+1);
    }

}
