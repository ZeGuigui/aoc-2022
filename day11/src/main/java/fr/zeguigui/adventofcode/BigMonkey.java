package fr.zeguigui.adventofcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BigMonkey {

    private final List<BigInteger> items = new ArrayList<>();
    private BigMonkey targetMonkeyTrue;
    private BigMonkey targetMonkeyFalse;
    private final Function<BigInteger,BigInteger> worryAdjust;
    private final Function<BigInteger,BigInteger> operation;
    private final Predicate<BigInteger> test;

    private long inspectedItemsCount = 0;

    public BigMonkey(List<Integer> startingItems, Function<BigInteger,BigInteger> worryAdjust, Function<BigInteger,BigInteger> operation, Predicate<BigInteger> test) {
        this.items.addAll(startingItems.stream().map(i -> BigInteger.valueOf(i)).collect(Collectors.toList()));
        this.worryAdjust = worryAdjust;
        this.operation = operation;
        this.test = test;
    }

    public List<BigInteger> getItems() {
        return this.items;
    }

    public void setTargetMonkeys(BigMonkey targetMonkeyTrue, BigMonkey targetMonkeyFalse) {
        this.targetMonkeyTrue = targetMonkeyTrue;
        this.targetMonkeyFalse = targetMonkeyFalse;
    }

    public void round() {
        // Consume items
        try {
            while (true) {
                BigInteger worryLevel = items.remove(0);
                worryLevel = operation.apply(worryLevel);
                worryLevel = worryAdjust.apply(worryLevel);
                throwItem(worryLevel, test.test(worryLevel) ? targetMonkeyTrue : targetMonkeyFalse);
                inspectedItemsCount++;
            }
        } catch (IndexOutOfBoundsException ex) {
            // List is empty!
        }
    }

    private void throwItem(BigInteger worryLevel, BigMonkey targetMonkey) {
        targetMonkey.receiveItem(worryLevel);
    }

    public void receiveItem(BigInteger item) {
        this.items.add(item);
    }

    public long getInspectedItemsCount() {
        return this.inspectedItemsCount;
    }

    public static long getBusinessActivity(int numberOfRounds, List<BigMonkey> monkeys) {
        for (int i = 0; i < numberOfRounds; i++) {
            monkeys.forEach(m -> m.round());
        }
        List<BigMonkey> activeMonkeys = monkeys.stream().sorted(Comparator.comparingLong(BigMonkey::getInspectedItemsCount).reversed()).collect(Collectors.toList());
        return activeMonkeys.get(0).getInspectedItemsCount() * activeMonkeys.get(1).getInspectedItemsCount();
    }

}
