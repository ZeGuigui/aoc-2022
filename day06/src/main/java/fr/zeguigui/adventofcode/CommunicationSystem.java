package fr.zeguigui.adventofcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CommunicationSystem {

    /**
     * Find the position of the first block of length distinct chars in line
     * @param line line to parse
     * @param length length of marker
     * @return position of marker
     */
    public static int findPositionDistinctChars(String line, int length) {
        int result = length;
        Set<String> setOfChars ;

        while (result < line.length()) {
            setOfChars = new HashSet<>(Arrays.asList(line.substring(result - length, result).split("",length)));
            if (setOfChars.size() == length) {
                break;
            }
            result++;
        }

        return result;
    }

    public static int findPosition(String line) {
        return findPositionDistinctChars(line, 4);
    }

    public static int findStartOfMessage(String line) {
        return findPositionDistinctChars(line, 14);
    }


}
