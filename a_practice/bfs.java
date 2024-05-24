package a_practice;

import java.util.*;

public class bfs{
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void create_graph(ArrayList<Edge> graph[], int V) {
        int d, n;
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < V; i++) {
            System.out.println("For src " + i);
            System.out.print("no. of branches: ");
            n = sc.nextInt();
            System.out.println("Enter the connections: ");
            for (int j = 0; j < n; j++) {
                d = sc.nextInt();
                graph[i].add(new Edge(i, d));
            }
        }
    }

     public static void bfs_graph(ArrayList<Edge> graph[], int V, int curr){
         Queue<Integer> q = new LinkedList<>();
         boolean vis[] = new boolean[V];

         q.add(curr);

         while(!q.isEmpty()){
             int pop = q.remove();
             if(vis[pop] == false){
                 System.out.print(pop+" ");
                 vis[pop] = true;

                 for(int i=0;i<graph[pop].size();i++){
                     Edge e = graph[pop].get(i);
                    q.add(e.dest);
                 }
             }
         }
     }

    public static void main(String args[]) {
        System.out.println("Compiling...");
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        create_graph(graph,V);
        System.out.print("The breadth first search: ");
         bfs_graph(graph,V,0);

    }
}
