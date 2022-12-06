package fr.zeguigui.adventofcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommunicationSystemTest {

    @Test
    void findPosition() {
        assertEquals(7, CommunicationSystem.findPosition("mjqjpqmgbljsphdztnvjfqwrcgsmlb"));
        assertEquals(5, CommunicationSystem.findPosition("bvwbjplbgvbhsrlpgdmjqwftvncz"));
        assertEquals(6, CommunicationSystem.findPosition("nppdvjthqldpwncqszvftbrmjlhg"));
        assertEquals(10, CommunicationSystem.findPosition("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"));
        assertEquals(11, CommunicationSystem.findPosition("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"));
    }

    @Test
    void findStartOfMessage() {
        assertEquals(19, CommunicationSystem.findStartOfMessage("mjqjpqmgbljsphdztnvjfqwrcgsmlb"));
        assertEquals(23, CommunicationSystem.findStartOfMessage("bvwbjplbgvbhsrlpgdmjqwftvncz"));
        assertEquals(23, CommunicationSystem.findStartOfMessage("nppdvjthqldpwncqszvftbrmjlhg"));
        assertEquals(29, CommunicationSystem.findStartOfMessage("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"));
        assertEquals(26, CommunicationSystem.findStartOfMessage("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"));
    }

}