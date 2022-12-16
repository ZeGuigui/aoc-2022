package fr.zeguigui.adventofcode;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {

    @Test
    void test1_Round() {

        Monkey monkey0 = new Monkey(List.of(79L,98L), x -> x / 3, x -> x * 19, x -> x % 23 == 0);
        Monkey monkey1 = new Monkey(List.of(54L,65L,75L,74L), x -> x / 3, x -> x+6, x -> x % 19 == 0);
        Monkey monkey2 = new Monkey(List.of(79L,60L,97L),x -> x / 3, x -> x*x, x -> x % 13 == 0);
        Monkey monkey3 = new Monkey(List.of(74L), x -> x / 3, x -> x + 3, x -> x % 17 == 0);

        monkey0.setTargetMonkeys(monkey2, monkey3);
        monkey1.setTargetMonkeys(monkey2, monkey0);
        monkey2.setTargetMonkeys(monkey1, monkey3);
        monkey3.setTargetMonkeys(monkey0, monkey1);

        monkey0.round();
        monkey1.round();
        monkey2.round();
        monkey3.round();

        assertIterableEquals(List.of(20L,23L,27L,26L), monkey0.getItems());
        assertIterableEquals(List.of(2080L,25L,167L,207L,401L,1046L), monkey1.getItems());
        assertIterableEquals(List.of(), monkey2.getItems());
        assertIterableEquals(List.of(), monkey3.getItems());

        // Make another round
        monkey0.round();
        monkey1.round();
        monkey2.round();
        monkey3.round();

        assertIterableEquals(List.of(695L,10L,71L,135L,350L), monkey0.getItems());
        assertIterableEquals(List.of(43L,49L,58L,55L,362L), monkey1.getItems());
        assertIterableEquals(List.of(), monkey2.getItems());
        assertIterableEquals(List.of(), monkey3.getItems());
    }

    @Test
    void test1_20Rounds() {

        Monkey monkey0 = new Monkey(List.of(79L,98L), x -> x / 3, x -> x * 19, x -> x % 23 == 0);
        Monkey monkey1 = new Monkey(List.of(54L,65L,75L,74L), x -> x / 3, x -> x+6, x -> x % 19 == 0);
        Monkey monkey2 = new Monkey(List.of(79L,60L,97L),x -> x / 3, x -> x*x, x -> x % 13 == 0);
        Monkey monkey3 = new Monkey(List.of(74L), x -> x / 3, x -> x + 3, x -> x % 17 == 0);

        monkey0.setTargetMonkeys(monkey2, monkey3);
        monkey1.setTargetMonkeys(monkey2, monkey0);
        monkey2.setTargetMonkeys(monkey1, monkey3);
        monkey3.setTargetMonkeys(monkey0, monkey1);

        for (int i = 0; i < 20; i++) {
            monkey0.round();
            monkey1.round();
            monkey2.round();
            monkey3.round();
        }

        assertIterableEquals(List.of(10L,12L,14L,26L,34L), monkey0.getItems());
        assertIterableEquals(List.of(245L,93L,53L,199L,115L), monkey1.getItems());
        assertIterableEquals(List.of(), monkey2.getItems());
        assertIterableEquals(List.of(), monkey3.getItems());
    }

    @Test
    void test1_BusinessActivity() {
        Monkey monkey0 = new Monkey(List.of(79L,98L), x -> x / 3, x -> x * 19, x -> x % 23 == 0);
        Monkey monkey1 = new Monkey(List.of(54L,65L,75L,74L), x -> x / 3, x -> x+6, x -> x % 19 == 0);
        Monkey monkey2 = new Monkey(List.of(79L,60L,97L),x -> x / 3, x -> x*x, x -> x % 13 == 0);
        Monkey monkey3 = new Monkey(List.of(74L), x -> x / 3, x -> x + 3, x -> x % 17 == 0);

        monkey0.setTargetMonkeys(monkey2, monkey3);
        monkey1.setTargetMonkeys(monkey2, monkey0);
        monkey2.setTargetMonkeys(monkey1, monkey3);
        monkey3.setTargetMonkeys(monkey0, monkey1);

        assertEquals(10605L, Monkey.getBusinessActivity(20, List.of(monkey0, monkey1, monkey2, monkey3)));
    }

    @Test
    void test1_InspectedItemsCount() {

        Monkey monkey0 = new Monkey(List.of(79L,98L), x -> x / 3, x -> x * 19, x -> x % 23 == 0);
        Monkey monkey1 = new Monkey(List.of(54L,65L,75L,74L), x -> x / 3, x -> x+6, x -> x % 19 == 0);
        Monkey monkey2 = new Monkey(List.of(79L,60L,97L),x -> x / 3, x -> x*x, x -> x % 13 == 0);
        Monkey monkey3 = new Monkey(List.of(74L), x -> x / 3, x -> x + 3, x -> x % 17 == 0);

        monkey0.setTargetMonkeys(monkey2, monkey3);
        monkey1.setTargetMonkeys(monkey2, monkey0);
        monkey2.setTargetMonkeys(monkey1, monkey3);
        monkey3.setTargetMonkeys(monkey0, monkey1);

        // 20 rounds
        for (int i = 0; i < 20; i++) {
            monkey0.round();
            monkey1.round();
            monkey2.round();
            monkey3.round();
        }

        assertEquals(101L, monkey0.getInspectedItemsCount());
        assertEquals(95L,  monkey1.getInspectedItemsCount());
        assertEquals(7L,   monkey2.getInspectedItemsCount());
        assertEquals(105L, monkey3.getInspectedItemsCount());
    }

    @Test
    void test1_BM_Round() {

        Function<BigInteger,BigInteger> worryAdjust = x -> x.divide(new BigInteger("3"));

        BigMonkey monkey0 = new BigMonkey(List.of(79,98), worryAdjust, x -> x.multiply(BigInteger.valueOf(19)), x -> x.mod(BigInteger.valueOf(23)).equals(BigInteger.valueOf(0)));
        BigMonkey monkey1 = new BigMonkey(List.of(54,65,75,74), worryAdjust, x -> x.add(BigInteger.valueOf(6)), x -> x.mod(BigInteger.valueOf(19)).equals(BigInteger.valueOf(0)));
        BigMonkey monkey2 = new BigMonkey(List.of(79,60,97), worryAdjust, x -> x.multiply(x), x -> x.mod(BigInteger.valueOf(13)).equals(BigInteger.valueOf(0)));
        BigMonkey monkey3 = new BigMonkey(List.of(74), worryAdjust, x -> x.add(BigInteger.valueOf(3)), x -> x.mod(BigInteger.valueOf(17)).equals(BigInteger.valueOf(0)));

        monkey0.setTargetMonkeys(monkey2, monkey3);
        monkey1.setTargetMonkeys(monkey2, monkey0);
        monkey2.setTargetMonkeys(monkey1, monkey3);
        monkey3.setTargetMonkeys(monkey0, monkey1);

        monkey0.round();
        monkey1.round();
        monkey2.round();
        monkey3.round();

        assertIterableEquals(List.of(20,23,27,26).stream().map(i -> BigInteger.valueOf(i)).collect(Collectors.toList()), monkey0.getItems());
        assertIterableEquals(List.of(2080,25,167,207,401,1046).stream().map(i -> BigInteger.valueOf(i)).collect(Collectors.toList()), monkey1.getItems());
        assertIterableEquals(List.of(), monkey2.getItems());
        assertIterableEquals(List.of(), monkey3.getItems());

        // Make another round
        monkey0.round();
        monkey1.round();
        monkey2.round();
        monkey3.round();

        assertIterableEquals(List.of(695L,10L,71L,135L,350L).stream().map(i -> BigInteger.valueOf(i)).collect(Collectors.toList()), monkey0.getItems());
        assertIterableEquals(List.of(43L,49L,58L,55L,362L).stream().map(i -> BigInteger.valueOf(i)).collect(Collectors.toList()), monkey1.getItems());
        assertIterableEquals(List.of(), monkey2.getItems());
        assertIterableEquals(List.of(), monkey3.getItems());
    }

    @Test
    void test1_BM_20Rounds() {

        Function<BigInteger,BigInteger> worryAdjust = x -> x.divide(new BigInteger("3"));
        BigMonkey monkey0 = new BigMonkey(List.of(79,98), worryAdjust, x -> x.multiply(BigInteger.valueOf(19)), x -> x.mod(BigInteger.valueOf(23)).equals(BigInteger.valueOf(0)));
        BigMonkey monkey1 = new BigMonkey(List.of(54,65,75,74), worryAdjust, x -> x.add(BigInteger.valueOf(6)), x -> x.mod(BigInteger.valueOf(19)).equals(BigInteger.valueOf(0)));
        BigMonkey monkey2 = new BigMonkey(List.of(79,60,97), worryAdjust, x -> x.multiply(x), x -> x.mod(BigInteger.valueOf(13)).equals(BigInteger.valueOf(0)));
        BigMonkey monkey3 = new BigMonkey(List.of(74), worryAdjust, x -> x.add(BigInteger.valueOf(3)), x -> x.mod(BigInteger.valueOf(17)).equals(BigInteger.valueOf(0)));

        monkey0.setTargetMonkeys(monkey2, monkey3);
        monkey1.setTargetMonkeys(monkey2, monkey0);
        monkey2.setTargetMonkeys(monkey1, monkey3);
        monkey3.setTargetMonkeys(monkey0, monkey1);

        for (int i = 0; i < 20; i++) {
            monkey0.round();
            monkey1.round();
            monkey2.round();
            monkey3.round();
        }

        assertIterableEquals(List.of(10L,12L,14L,26L,34L).stream().map(i -> BigInteger.valueOf(i)).collect(Collectors.toList()), monkey0.getItems());
        assertIterableEquals(List.of(245L,93L,53L,199L,115L).stream().map(i -> BigInteger.valueOf(i)).collect(Collectors.toList()), monkey1.getItems());
        assertIterableEquals(List.of(), monkey2.getItems());
        assertIterableEquals(List.of(), monkey3.getItems());
    }

    @Test
    void test1_BM_BusinessActivity() {
        Function<BigInteger,BigInteger> worryAdjust = x -> x.divide(new BigInteger("3"));
        BigMonkey monkey0 = new BigMonkey(List.of(79,98), worryAdjust, x -> x.multiply(BigInteger.valueOf(19)), x -> x.mod(BigInteger.valueOf(23)).equals(BigInteger.valueOf(0)));
        BigMonkey monkey1 = new BigMonkey(List.of(54,65,75,74), worryAdjust, x -> x.add(BigInteger.valueOf(6)), x -> x.mod(BigInteger.valueOf(19)).equals(BigInteger.valueOf(0)));
        BigMonkey monkey2 = new BigMonkey(List.of(79,60,97), worryAdjust, x -> x.multiply(x), x -> x.mod(BigInteger.valueOf(13)).equals(BigInteger.valueOf(0)));
        BigMonkey monkey3 = new BigMonkey(List.of(74), worryAdjust, x -> x.add(BigInteger.valueOf(3)), x -> x.mod(BigInteger.valueOf(17)).equals(BigInteger.valueOf(0)));

        monkey0.setTargetMonkeys(monkey2, monkey3);
        monkey1.setTargetMonkeys(monkey2, monkey0);
        monkey2.setTargetMonkeys(monkey1, monkey3);
        monkey3.setTargetMonkeys(monkey0, monkey1);

        assertEquals(10605L, BigMonkey.getBusinessActivity(20, List.of(monkey0, monkey1, monkey2, monkey3)));
    }

    @Test
    void test1_BM_InspectedItemsCount() {

        Function<BigInteger,BigInteger> worryAdjust = x -> x.divide(new BigInteger("3"));
        BigMonkey monkey0 = new BigMonkey(List.of(79,98), worryAdjust, x -> x.multiply(BigInteger.valueOf(19)), x -> x.mod(BigInteger.valueOf(23)).equals(BigInteger.valueOf(0)));
        BigMonkey monkey1 = new BigMonkey(List.of(54,65,75,74), worryAdjust, x -> x.add(BigInteger.valueOf(6)), x -> x.mod(BigInteger.valueOf(19)).equals(BigInteger.valueOf(0)));
        BigMonkey monkey2 = new BigMonkey(List.of(79,60,97), worryAdjust, x -> x.multiply(x), x -> x.mod(BigInteger.valueOf(13)).equals(BigInteger.valueOf(0)));
        BigMonkey monkey3 = new BigMonkey(List.of(74), worryAdjust, x -> x.add(BigInteger.valueOf(3)), x -> x.mod(BigInteger.valueOf(17)).equals(BigInteger.valueOf(0)));

        monkey0.setTargetMonkeys(monkey2, monkey3);
        monkey1.setTargetMonkeys(monkey2, monkey0);
        monkey2.setTargetMonkeys(monkey1, monkey3);
        monkey3.setTargetMonkeys(monkey0, monkey1);

        // 20 rounds
        for (int i = 0; i < 20; i++) {
            monkey0.round();
            monkey1.round();
            monkey2.round();
            monkey3.round();
        }

        assertEquals(101L, monkey0.getInspectedItemsCount());
        assertEquals(95L,  monkey1.getInspectedItemsCount());
        assertEquals(7L,   monkey2.getInspectedItemsCount());
        assertEquals(105L, monkey3.getInspectedItemsCount());
    }

    @Test
    void test2_Round() {
        BigMonkey monkey0 = new BigMonkey(List.of(79,98), x -> x , x -> x.multiply(new BigInteger("19")), x -> x.mod(new BigInteger("23")).longValue() == 0);
        BigMonkey monkey1 = new BigMonkey(List.of(54,65,75,74), x -> x , x -> x.add(new BigInteger("6")), x -> x.mod(new BigInteger("19")).longValue() == 0);
        BigMonkey monkey2 = new BigMonkey(List.of(79,60,97),x -> x , x -> x.multiply(x), x -> x.mod(new BigInteger("13")).longValue() == 0);
        BigMonkey monkey3 = new BigMonkey(List.of(74), x -> x , x -> x.add(new BigInteger("3")), x -> x.mod(new BigInteger("17")).longValue() == 0);

        monkey0.setTargetMonkeys(monkey2, monkey3);
        monkey1.setTargetMonkeys(monkey2, monkey0);
        monkey2.setTargetMonkeys(monkey1, monkey3);
        monkey3.setTargetMonkeys(monkey0, monkey1);

        monkey0.round();
        monkey1.round();
        monkey2.round();
        monkey3.round();

        assertEquals(2L, monkey0.getInspectedItemsCount());
        assertEquals(4L, monkey1.getInspectedItemsCount());
        assertEquals(3L,  monkey2.getInspectedItemsCount());
        assertEquals(6L, monkey3.getInspectedItemsCount());
    }

    @Test
    void test2_20Rounds() {
        BigMonkey monkey0 = new BigMonkey(List.of(79,98), x -> x , x -> x.multiply(new BigInteger("19")), x -> x.mod(new BigInteger("23")).longValue() == 0);
        BigMonkey monkey1 = new BigMonkey(List.of(54,65,75,74), x -> x , x -> x.add(new BigInteger("6")), x -> x.mod(new BigInteger("19")).longValue() == 0);
        BigMonkey monkey2 = new BigMonkey(List.of(79,60,97),x -> x , x -> x.multiply(x), x -> x.mod(new BigInteger("13")).longValue() == 0);
        BigMonkey monkey3 = new BigMonkey(List.of(74), x -> x , x -> x.add(new BigInteger("3")), x -> x.mod(new BigInteger("17")).longValue() == 0);

        monkey0.setTargetMonkeys(monkey2, monkey3);
        monkey1.setTargetMonkeys(monkey2, monkey0);
        monkey2.setTargetMonkeys(monkey1, monkey3);
        monkey3.setTargetMonkeys(monkey0, monkey1);

        for (int i = 0; i < 20; i++) {
            monkey0.round();
            monkey1.round();
            monkey2.round();
            monkey3.round();
        }

        assertEquals(99L,  monkey0.getInspectedItemsCount());
        assertEquals(97L,  monkey1.getInspectedItemsCount());
        assertEquals(8L,   monkey2.getInspectedItemsCount());
        assertEquals(103L, monkey3.getInspectedItemsCount());
    }

    @Test
    void test2_1000Rounds() {
        BigMonkey monkey0 = new BigMonkey(List.of(79,98), x -> x , x -> x.multiply(BigInteger.valueOf(19)), x -> x.mod(BigInteger.valueOf(23)).equals(BigInteger.ZERO));
        BigMonkey monkey1 = new BigMonkey(List.of(54,65,75,74), x -> x , x -> x.add(BigInteger.valueOf(6)), x -> x.mod(BigInteger.valueOf(19)).equals(BigInteger.ZERO));
        BigMonkey monkey2 = new BigMonkey(List.of(79,60,97),x -> x , x -> x.multiply(x), x -> x.mod(BigInteger.valueOf(13)).equals(BigInteger.ZERO));
        BigMonkey monkey3 = new BigMonkey(List.of(74), x -> x , x -> x.add(BigInteger.valueOf(3)), x -> x.mod(BigInteger.valueOf(17)).equals(BigInteger.ZERO));

        monkey0.setTargetMonkeys(monkey2, monkey3);
        monkey1.setTargetMonkeys(monkey2, monkey0);
        monkey2.setTargetMonkeys(monkey1, monkey3);
        monkey3.setTargetMonkeys(monkey0, monkey1);

        for (int i = 0; i < 1000; i++) {
            monkey0.round();
            monkey1.round();
            monkey2.round();
            monkey3.round();
        }

        assertEquals(5204L,  monkey0.getInspectedItemsCount());
        assertEquals(4792L,  monkey1.getInspectedItemsCount());
        assertEquals(199L,   monkey2.getInspectedItemsCount());
        assertEquals(5192L,  monkey3.getInspectedItemsCount());
    }

    @Test
    @Disabled
    void test2_10000_Rounds() {
        // java.lang.ArithmeticException: BigInteger would overflow supported range... there must me something better to do!
        BigMonkey monkey0 = new BigMonkey(List.of(79,98), x -> x , x -> x.multiply(BigInteger.valueOf(19)), x -> x.mod(BigInteger.valueOf(23)).equals(BigInteger.ZERO));
        BigMonkey monkey1 = new BigMonkey(List.of(54,65,75,74), x -> x , x -> x.add(BigInteger.valueOf(6)), x -> x.mod(BigInteger.valueOf(19)).equals(BigInteger.ZERO));
        BigMonkey monkey2 = new BigMonkey(List.of(79,60,97),x -> x , x -> x.multiply(x), x -> x.mod(BigInteger.valueOf(13)).equals(BigInteger.ZERO));
        BigMonkey monkey3 = new BigMonkey(List.of(74), x -> x , x -> x.add(BigInteger.valueOf(3)), x -> x.mod(BigInteger.valueOf(17)).equals(BigInteger.ZERO));

        monkey0.setTargetMonkeys(monkey2, monkey3);
        monkey1.setTargetMonkeys(monkey2, monkey0);
        monkey2.setTargetMonkeys(monkey1, monkey3);
        monkey3.setTargetMonkeys(monkey0, monkey1);

        for (int i = 0; i < 10000; i++) {
            monkey0.round();
            monkey1.round();
            monkey2.round();
            monkey3.round();
        }

        assertEquals(52166L, monkey0.getInspectedItemsCount());
        assertEquals(47830L, monkey1.getInspectedItemsCount());
        assertEquals(1938L,  monkey2.getInspectedItemsCount());
        assertEquals(52013L, monkey3.getInspectedItemsCount());
    }

    @Test
    @Disabled
    void test2_BusinessActivit() {
        BigMonkey monkey0 = new BigMonkey(List.of(79,98), x -> x , x -> x.multiply(BigInteger.valueOf(19)), x -> x.mod(BigInteger.valueOf(23)).equals(BigInteger.ZERO));
        BigMonkey monkey1 = new BigMonkey(List.of(54,65,75,74), x -> x , x -> x.add(BigInteger.valueOf(6)), x -> x.mod(BigInteger.valueOf(19)).equals(BigInteger.ZERO));
        BigMonkey monkey2 = new BigMonkey(List.of(79,60,97),x -> x , x -> x.multiply(x), x -> x.mod(BigInteger.valueOf(13)).equals(BigInteger.ZERO));
        BigMonkey monkey3 = new BigMonkey(List.of(74), x -> x , x -> x.add(BigInteger.valueOf(3)), x -> x.mod(BigInteger.valueOf(17)).equals(BigInteger.ZERO));

        monkey0.setTargetMonkeys(monkey2, monkey3);
        monkey1.setTargetMonkeys(monkey2, monkey0);
        monkey2.setTargetMonkeys(monkey1, monkey3);
        monkey3.setTargetMonkeys(monkey0, monkey1);

        assertEquals(2713310158L, BigMonkey.getBusinessActivity(10000, List.of(monkey0, monkey1, monkey2, monkey3)));
    }
}