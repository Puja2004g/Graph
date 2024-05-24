package a_practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class graph_using_hashmap {
    public static class edge{
        int inx;
        HashMap<String, String> places = new HashMap<String, String>();

        public edge(int index, HashMap<String, String> p){
            this.inx = index;
            this.places = p;
        }
    }

    public static void create_graph_string(ArrayList<edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<edge>();
        }

        String[][] edges = {
                {"India", "Jharkhand"},
                {"Jharkhand", "Ranchi"},
                {"India", "West Bengal"},
                {"West Bengal", "Kolkata"},
                {"Ranchi", "Deoghar"},
                {"Kolkata", "Deoghar"}
        };

        for(int i=0;i<edges.length;i++){
            HashMap<String, String> places = new HashMap<String, String>();
            places.put(edges[i][0], edges[i][1]);
            graph[i].add(new edge(i,places));
        }
    }

    public static void main(String args[]){
        int V = 6;  // Number of vertices for the example
        ArrayList<edge>[] graph = new ArrayList[V];

        create_graph_string(graph);

        // Printing the graph to verify
        for (int i = 0; i < graph.length; i++) {
            for (edge e : graph[i]) {
                System.out.println(e.places);
            }
        }
    }
}
