package a_practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class strings_graph {
    public static class Edge {
        String src;
        String dest;

        public Edge(String s, String d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void create_graph_string(ArrayList<Edge>[] place) {
        for (int i = 0; i < place.length; i++) {
            place[i] = new ArrayList<Edge>();
        }

        place[0].add(new Edge("India", "Jharkhand"));
        place[0].add(new Edge("India", "West Bengal"));
        place[1].add(new Edge("Jharkhand", "Ranchi"));
        place[2].add(new Edge("West Bengal", "Kolkata"));
        place[3].add(new Edge("Ranchi", "Deoghar"));
        place[4].add(new Edge("Kolkata", "Deoghar"));
    }

    public static void breadthFirstSearch(ArrayList<Edge>[] place, String start, int v, HashMap<String, Integer> vertexIndex) {
        Queue<String> q = new LinkedList<>();
        boolean[] vis = new boolean[v];

        // Map the starting vertex to its index and mark it as visited
        int startIndex = vertexIndex.get(start);
        q.add(start);
        vis[startIndex] = true;

        while (!q.isEmpty()) {
            String curr = q.remove();

            // Get the current vertex index
            int currIndex = vertexIndex.get(curr);

            // Traverse the adjacency list of the current vertex
            for (Edge edge : place[currIndex]) {
                String neighbor = edge.dest;
                int neighborIndex = vertexIndex.get(neighbor);

                // If the neighbor hasn't been visited yet, mark it and enqueue it
                if (!vis[neighborIndex]) {
                    vis[neighborIndex] = true;
                    q.add(neighbor);
                    System.out.println( edge.src + " -> " + edge.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        int v = 6; // Number of vertices (unique places)
        ArrayList<Edge>[] place = new ArrayList[v];

        create_graph_string(place);

        // Mapping vertex names to indices
        HashMap<String, Integer> vertexIndex = new HashMap<>();
        vertexIndex.put("India", 0);
        vertexIndex.put("Jharkhand", 1);
        vertexIndex.put("West Bengal", 2);
        vertexIndex.put("Ranchi", 3);
        vertexIndex.put("Kolkata", 4);
        vertexIndex.put("Deoghar", 5);

        // Perform BFS starting from "India"
        breadthFirstSearch(place, "India", v, vertexIndex);
    }
}
