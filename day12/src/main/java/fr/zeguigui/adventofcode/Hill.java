package fr.zeguigui.adventofcode;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.AStarShortestPath;
import org.jgrapht.alg.shortestpath.AllDirectedPaths;
import org.jgrapht.alg.shortestpath.BellmanFordShortestPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedPseudograph;
import org.jgrapht.graph.SimpleDirectedGraph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hill {

    private final int width;
    private final int height;
    private Point start;
    private Point end;

    private Graph<Point, DefaultEdge> heatMap = new SimpleDirectedGraph<>(DefaultEdge.class);

    public Hill(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int computeShortestPathLength() {
        BellmanFordShortestPath<Point, DefaultEdge> shortestPathAlgorithm = new BellmanFordShortestPath<>(this.heatMap);
        ShortestPathAlgorithm.SingleSourcePaths<Point, DefaultEdge> paths = shortestPathAlgorithm.getPaths(this.start);
        return paths.getPath(this.end).getLength();
    }

    public void parseHeatmap(List<String> heatmap) {
        Map<Point, Integer> altitudes = new HashMap<>();

        // Add vertexes
        for (int rowIdx = 0; rowIdx < height; rowIdx++) {
            String row = heatmap.get(rowIdx);
            for (int i = 0; i < width; i++) {
                Point p = new Point(i, rowIdx);
                this.heatMap.addVertex(p);
                altitudes.put(p, Point.getAltitude(row.charAt(i)));
                if (row.charAt(i) == 'S') {
                    this.start = p;
                }
                if (row.charAt(i) == 'E') {
                    this.end = p;
                }
            }
        }
        // Add edges
        int degrees = 0;
        for (int rowIdx = 0; rowIdx < height; rowIdx++) {
            for (int i = 0; i < width; i++) {
                // Check neighbourgs
                Point currentPosition = new Point(i, rowIdx);

                int elevation     = altitudes.get(currentPosition);
                int upAltitude    = rowIdx == 0 ? -100 : altitudes.get(currentPosition.upper());
                int downAltitude  = rowIdx + 1 == height ? -100 : altitudes.get(currentPosition.down());
                int rightAltitude = i + 1 == width ? -100 : altitudes.get(currentPosition.right());
                int leftAltitude  = i == 0 ? -100 : altitudes.get(currentPosition.left());

                if (canClimb(elevation, upAltitude)) {
                    this.heatMap.addEdge(currentPosition, currentPosition.upper());
                    degrees++;
                }
                if (canClimb(elevation, downAltitude)) {
                    this.heatMap.addEdge(currentPosition, currentPosition.down());
                    degrees++;
                }
                if (canClimb(elevation, leftAltitude)) {
                    this.heatMap.addEdge(currentPosition, currentPosition.left());
                    degrees++;
                }
                if (canClimb(elevation, rightAltitude)) {
                    this.heatMap.addEdge(currentPosition, currentPosition.right());
                    degrees++;
                }
                // System.out.println(currentPosition + " -> can go in " + degrees + " directions");
            }
        }
        System.out.println("Number of possible directions: " + degrees);
        System.out.println("Number of edges: " + this.heatMap.edgeSet().size());

    }

    private boolean canClimb(int start, int to) {
        return (start == to) || (start == to - 1);
    }

    public Point getStart() {
        return this.start;
    }

    public Point getEnd() {
        return this.end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public Graph<Point, DefaultEdge> getHeatMap() {
        return this.heatMap;
    }

}
