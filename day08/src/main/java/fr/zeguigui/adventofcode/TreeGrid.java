package fr.zeguigui.adventofcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TreeGrid {

    private final List<List<Integer>> treeGrid = new ArrayList<>();

    public void addRowOfTrees(String trees) {
        String[] treeHeights = trees.split("");
        List<Integer> treeRow = new ArrayList<>();
        for (String h : treeHeights) {
            treeRow.add(Integer.valueOf(h));
        }
        treeGrid.add(treeRow);
    }

    public List<Integer> getRow(int row) {
        return treeGrid.get(row);
    }

    public List<Integer> getColumn(int col) {
        List<Integer> result = new ArrayList<>();
        treeGrid.forEach(row -> result.add(row.get(col)));
        return result;
    }

    /**
     * A tree is visible if all of the other trees between it and an edge of the grid are
     * shorter than it. Only consider trees in the same row or column; that is, only look
     * up, down, left, or right from any given tree.
     * @param row row
     * @param column column
     * @return true is tree is visible
     */
    public boolean isTreeVisible(int row, int column) {

        int numberOfRows = treeGrid.size();
        int numberOfCols = treeGrid.get(0).size();

        // Edge
        if ((row == 0) || (row == numberOfRows - 1) || (column == 0) || (column == numberOfCols - 1)) {
            return true;
        }

        List<Integer> treeRow = this.getRow(row);
        List<Integer> treeCol = this.getColumn(column);
        int height = treeRow.get(column);

        return isVisible(height, treeRow.subList(0, column)) || isVisible(height, treeRow.subList(column + 1, treeRow.size())) ||
                isVisible(height, treeCol.subList(0, row)) || isVisible(height, treeCol.subList(row + 1, treeCol.size()));
    }

    public Integer getTreeHeight(int row, int col) {
        return this.getRow(row).get(col);
    }

    public static int getNumberOfVisibleNeighbours(int tree, List<Integer> neighbours) {
        int result = 0;

        for (int neighbour : neighbours) {
            result++;
            if (tree <= neighbour) {
                break;
            }
        }

        return result;
    }

    public static <T> Collector<T, ?, List<T>> toReversedList() {
        return Collectors.collectingAndThen(Collectors.toList(), l -> {
            Collections.reverse(l);
            return l;
        });
    }

    public Integer getScenicScore(int row, int column) {
        List<Integer> treeRow = this.getRow(row);
        List<Integer> treeCol = this.getColumn(column);
        int height = this.getTreeHeight(row, column);

        int scenicScoreUp    = getNumberOfVisibleNeighbours(height, treeCol.subList(0, row).stream().collect(toReversedList()));
        int scenicScoreLeft  = getNumberOfVisibleNeighbours(height, treeRow.subList(0, column).stream().collect(toReversedList()));
        int scenicScoreRight = getNumberOfVisibleNeighbours(height, treeRow.subList(column + 1, treeRow.size()));
        int scenicScoreDown  = getNumberOfVisibleNeighbours(height, treeCol.subList(row + 1, treeCol.size()));

        return scenicScoreLeft * scenicScoreRight * scenicScoreUp * scenicScoreDown;
    }

    public static boolean isVisible (int height, List<Integer> heights) {
        Optional<Integer> higherTree = heights.stream().filter(h -> h >= height).findAny();
        return higherTree.isEmpty();
    }

    public int getMaxScenicView() {
        List<Integer> scenicScore = new ArrayList<>();

        int numberOfRows = treeGrid.size();
        int numberOfCols = treeGrid.get(0).size();


        // Trees in the inside
        for (int row = 1; row < numberOfRows - 1; row++) {
            for (int col = 1; col < numberOfCols - 1; col++) {
                scenicScore.add(getScenicScore(row, col));
            }
        }

        return scenicScore.stream().max(Integer::compareTo).orElse(-1);
    }

    public int getNumberOfVisibleTree() {
        // Trees on the edge (corner trees are counted twice with perimeter method)
        int numberOfRows = treeGrid.size();
        int numberOfCols = treeGrid.get(0).size();

        int numberOfTrees = (numberOfRows + numberOfCols) * 2 - 4;

        // Trees in the inside
        for (int row = 1; row < numberOfRows - 1; row++) {
            for (int col = 1; col < numberOfCols - 1; col++) {
                if (this.isTreeVisible(row, col)) {
                    numberOfTrees++;
                }
            }
        }

        return numberOfTrees;
    }

}
