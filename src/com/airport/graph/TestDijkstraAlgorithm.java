package com.airport.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestDijkstraAlgorithm {
	
	public static void main(String args[]) {
		List<Vertex> nodes;
	    List<Edge> edges;
	    nodes = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();
        for (int i = 0; i < 11; i++) {
            Vertex location = new Vertex("Node_" + i, "Node_" + i);
            nodes.add(location);
        }

        addLane("Edge_0", 0, 1, 85, nodes, edges);
        addLane("Edge_1", 0, 2, 217, nodes, edges);
        addLane("Edge_2", 0, 4, 173, nodes, edges);
        addLane("Edge_3", 2, 6, 186, nodes, edges);
        addLane("Edge_4", 2, 7, 103, nodes, edges);
        addLane("Edge_5", 3, 7, 183, nodes, edges);
        addLane("Edge_6", 5, 8, 250, nodes, edges);
        addLane("Edge_7", 8, 9, 84, nodes, edges);
        addLane("Edge_8", 7, 9, 167, nodes, edges);
        addLane("Edge_9", 4, 9, 502, nodes, edges);
        addLane("Edge_10", 9, 10, 40, nodes, edges);
        addLane("Edge_11", 1, 10, 600, nodes, edges);
        //reverse
        addLane("Edge_0", 1, 0, 85, nodes, edges);
        addLane("Edge_1", 2, 0, 217, nodes, edges);
        addLane("Edge_2", 4, 0, 173, nodes, edges);
        addLane("Edge_3", 6, 2, 186, nodes, edges);
        addLane("Edge_4", 7, 2, 103, nodes, edges);
        addLane("Edge_5", 7, 3, 183, nodes, edges);
        addLane("Edge_6", 8, 5, 250, nodes, edges);
        addLane("Edge_7", 9, 8, 84, nodes, edges);
        addLane("Edge_8", 9, 7, 167, nodes, edges);
        addLane("Edge_9", 9, 4, 502, nodes, edges);
        addLane("Edge_10", 10, 9, 40, nodes, edges);
        addLane("Edge_11", 10, 1, 600, nodes, edges);
        

        // Lets check from location Loc_1 to Loc_10
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(edges);
        dijkstra.execute(nodes.get(10));
        LinkedList<Vertex> path = dijkstra.getPath(nodes.get(4));

        System.out.println(path);
        //assertTrue(path.size() > 0);

        for (Vertex vertex : path) {
            System.out.println(vertex);
        }
	}
	
	static void addLane(String laneId, int sourceLocNo, int destLocNo,
            int duration, List<Vertex> nodes, List<Edge> edges) {
		Edge lane = new Edge(laneId,nodes.get(sourceLocNo), nodes.get(destLocNo), duration );
        edges.add(lane);
    }

}
