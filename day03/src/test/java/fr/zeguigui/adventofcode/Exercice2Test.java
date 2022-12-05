package fr.zeguigui.adventofcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercice2Test {

    @Test
    void getCommonItem() {
        assertEquals('r', Exercice2.getCommonItem("vJrwpWtwJgWrhcsFMMfFFhFp","jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL","PmmdzqPrVvPwwTWBwg"));
        assertEquals('Z', Exercice2.getCommonItem("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn","ttgJtRGJQctTZtZT","CrZsJsPPZsGzwwsLwLmpwMDw"));
    }
}