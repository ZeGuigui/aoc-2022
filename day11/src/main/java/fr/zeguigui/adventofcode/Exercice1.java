package fr.zeguigui.adventofcode;

import java.util.List;

public class Exercice1 {


    public static void main(String[] args) {

        Monkey monkey0 = new Monkey(List.of(57L,58L), x -> x / 3, x -> x * 19, x -> x % 7 == 0);
        Monkey monkey1 = new Monkey(List.of(66L,52L,59L,79L,94L,73L), x -> x / 3, x -> x + 1,  x -> x % 19 == 0);
        Monkey monkey2 = new Monkey(List.of(80L), x -> x / 3, x -> x + 6,  x -> x % 5 == 0);
        Monkey monkey3 = new Monkey(List.of(82L,81L,68L,66L,71L,83L,75L,97L), x -> x / 3, x -> x + 5,  x -> x % 11 == 0);
        Monkey monkey4 = new Monkey(List.of(55L,52L,67L,70L,69L,94L,90L), x -> x / 3, x -> x * x,  x -> x % 17 == 0);
        Monkey monkey5 = new Monkey(List.of(69L,85L,89L,91L), x -> x / 3, x -> x + 7,  x -> x % 13 == 0);
        Monkey monkey6 = new Monkey(List.of(75L,53L,73L,52L,75L), x -> x / 3, x -> x * 7,  x -> x % 2 == 0);
        Monkey monkey7 = new Monkey(List.of(94L,60L,79L), x -> x / 3, x -> x + 2,  x -> x % 3 == 0);

        monkey0.setTargetMonkeys(monkey2, monkey3);
        monkey1.setTargetMonkeys(monkey4, monkey6);
        monkey2.setTargetMonkeys(monkey7, monkey5);
        monkey3.setTargetMonkeys(monkey5, monkey2);
        monkey4.setTargetMonkeys(monkey0, monkey3);
        monkey5.setTargetMonkeys(monkey1, monkey7);
        monkey6.setTargetMonkeys(monkey0, monkey4);
        monkey7.setTargetMonkeys(monkey1, monkey6);

        List<Monkey> monkeys = List.of(monkey0, monkey1, monkey2, monkey3, monkey4, monkey5, monkey6, monkey7 );
        System.out.println("Business activity: " + Monkey.getBusinessActivity(20, monkeys));
    }

}
