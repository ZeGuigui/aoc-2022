package fr.zeguigui.adventofcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.LongFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Monkey {

    private final List<Long> items = new ArrayList<>();
    private Monkey targetMonkeyTrue;
    private Monkey targetMonkeyFalse;
    private final LongFunction<Long> worryAdjust;
    private final LongFunction<Long> operation;
    private final Predicate<Long> test;

    private long inspectedItemsCount = 0;

    public Monkey(List<Long> startingItems, LongFunction<Long> worryAdjust, LongFunction<Long> operation, Predicate<Long> test) {
        this.items.addAll(startingItems);
        this.worryAdjust = worryAdjust;
        this.operation = operation;
        this.test = test;
    }

    public List<Long> getItems() {
        return this.items;
    }

    public void setTargetMonkeys(Monkey targetMonkeyTrue, Monkey targetMonkeyFalse) {
        this.targetMonkeyTrue = targetMonkeyTrue;
        this.targetMonkeyFalse = targetMonkeyFalse;
    }

    public void round() {
        // Consume items
        try {
            while (true) {
                long worryLevel = items.remove(0);
                worryLevel = operation.apply(worryLevel);
                worryLevel = worryAdjust.apply(worryLevel);
                throwItem(worryLevel, test.test(worryLevel) ? targetMonkeyTrue : targetMonkeyFalse);
                inspectedItemsCount++;
            }
        } catch (IndexOutOfBoundsException ex) {
            // List is empty!
        }
    }

    private void throwItem(long worryLevel, Monkey targetMonkey) {
        targetMonkey.receiveItem(worryLevel);
    }

    public void receiveItem(long item) {
        this.items.add(item);
    }

    public long getInspectedItemsCount() {
        return this.inspectedItemsCount;
    }

    public static long getBusinessActivity(int numberOfRounds, List<Monkey> monkeys) {
        for (int i = 0; i < numberOfRounds; i++) {
            monkeys.forEach(m -> m.round());
        }
        List<Monkey> activeMonkeys = monkeys.stream().sorted(Comparator.comparingLong(Monkey::getInspectedItemsCount).reversed()).collect(Collectors.toList());
        return activeMonkeys.get(0).getInspectedItemsCount() * activeMonkeys.get(1).getInspectedItemsCount();
    }

}
