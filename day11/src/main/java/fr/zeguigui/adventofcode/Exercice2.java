package fr.zeguigui.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exercice2 {

    public static void main(String[] args) {

        // BigInteger alone is not enough and would be too slow!
        // Could have use initial Monkey class :-)
        int spaceSize = 7*19*5*11*17*13*2*3;
        Function<BigInteger, BigInteger> worryAdjust = x -> x.mod(BigInteger.valueOf(spaceSize));
        BigMonkey monkey0 = new BigMonkey(List.of(57,58), worryAdjust, x -> x.multiply(BigInteger.valueOf(19)), x -> x.mod(BigInteger.valueOf(7)).equals(BigInteger.ZERO));
        BigMonkey monkey1 = new BigMonkey(List.of(66,52,59,79,94,73), worryAdjust, x -> x.add(BigInteger.valueOf(1)),  x -> x.mod(BigInteger.valueOf(19)).equals(BigInteger.ZERO));
        BigMonkey monkey2 = new BigMonkey(List.of(80), worryAdjust, x -> x.add(BigInteger.valueOf(6)),  x -> x.mod(BigInteger.valueOf(5)).equals(BigInteger.ZERO));
        BigMonkey monkey3 = new BigMonkey(List.of(82,81,68,66,71,83,75,97), worryAdjust, x -> x.add(BigInteger.valueOf(5)),  x -> x.mod(BigInteger.valueOf(11)).equals(BigInteger.ZERO));
        BigMonkey monkey4 = new BigMonkey(List.of(55,52,67,70,69,94,90), worryAdjust, x -> x.multiply(x),  x -> x.mod(BigInteger.valueOf(17)).equals(BigInteger.ZERO));
        BigMonkey monkey5 = new BigMonkey(List.of(69,85,89,91), worryAdjust, x -> x.add(BigInteger.valueOf(7)),  x -> x.mod(BigInteger.valueOf(13)).equals(BigInteger.ZERO));
        BigMonkey monkey6 = new BigMonkey(List.of(75,53,73,52,75), worryAdjust, x -> x.multiply(BigInteger.valueOf(7)),  x -> x.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO));
        BigMonkey monkey7 = new BigMonkey(List.of(94,60,79), worryAdjust, x -> x.add(BigInteger.valueOf(2)),  x -> x.mod(BigInteger.valueOf(3)).equals(BigInteger.ZERO));

        monkey0.setTargetMonkeys(monkey2, monkey3);
        monkey1.setTargetMonkeys(monkey4, monkey6);
        monkey2.setTargetMonkeys(monkey7, monkey5);
        monkey3.setTargetMonkeys(monkey5, monkey2);
        monkey4.setTargetMonkeys(monkey0, monkey3);
        monkey5.setTargetMonkeys(monkey1, monkey7);
        monkey6.setTargetMonkeys(monkey0, monkey4);
        monkey7.setTargetMonkeys(monkey1, monkey6);

        List<BigMonkey> monkeys = List.of(monkey0, monkey1, monkey2, monkey3, monkey4, monkey5, monkey6, monkey7 );
        System.out.println("Business activity: " + BigMonkey.getBusinessActivity(10000, monkeys));
    }

}
