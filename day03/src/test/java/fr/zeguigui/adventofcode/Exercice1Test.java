package fr.zeguigui.adventofcode;

import static org.junit.jupiter.api.Assertions.*;

class Exercice1Test {

    @org.junit.jupiter.api.Test
    void findItem() {
        assertEquals('p', Exercice1.findItem("vJrwpWtwJgWrhcsFMMfFFhFp"));
        assertEquals('L', Exercice1.findItem("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL"));
        assertEquals('P', Exercice1.findItem("PmmdzqPrVvPwwTWBwg"));
        assertEquals('v', Exercice1.findItem("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn"));
        assertEquals('t', Exercice1.findItem("ttgJtRGJQctTZtZT"));
        assertEquals('s', Exercice1.findItem("CrZsJsPPZsGzwwsLwLmpwMDw"));
    }

    @org.junit.jupiter.api.Test
    void getPriority() {
        assertEquals(16, Exercice1.getPriority("vJrwpWtwJgWrhcsFMMfFFhFp"));
        assertEquals(38, Exercice1.getPriority("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL"));
        assertEquals(42, Exercice1.getPriority("PmmdzqPrVvPwwTWBwg"));
        assertEquals(22, Exercice1.getPriority("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn"));
        assertEquals(20, Exercice1.getPriority("ttgJtRGJQctTZtZT"));
        assertEquals(19, Exercice1.getPriority("CrZsJsPPZsGzwwsLwLmpwMDw"));
    }
}