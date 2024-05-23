import java.util.*;

public class topological_sorting {
    public static void create_directed_graph(ArrayList<create_graph.Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<create_graph.Edge>();
        }
        graph[2].add(new create_graph.Edge(2, 3));
        graph[3].add(new create_graph.Edge(3, 1));
        graph[4].add(new create_graph.Edge(4, 0));
        graph[4].add(new create_graph.Edge(4, 1));
        graph[5].add(new create_graph.Edge(5, 0));
        graph[5].add(new create_graph.Edge(5, 2));
    }

    public static void topSortUtil(ArrayList<create_graph.Edge>[] graph,int curr, boolean[] vis, Stack<Integer> stack) {
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++) {
            create_graph.Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, stack);
            }
        }
        stack.push(curr);
    }

    public static void topSort(ArrayList<create_graph.Edge>[] graph, int v) {
        boolean vis[] = new boolean[v];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<v;i++){
            if(!vis[i]){
                topSortUtil(graph, i, vis, stack);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }

    public static void main(String args[]) {
        int v = 6;
        ArrayList<create_graph.Edge> graph[] = new ArrayList[v];
        create_directed_graph(graph);

        topSort(graph, v);
    }
}
