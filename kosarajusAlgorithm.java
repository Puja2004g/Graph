import java.util.ArrayList;
import java.util.Stack;

public class kosarajusAlgorithm {
    public static void create_directed_graph(ArrayList<create_graph.Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<create_graph.Edge>();
        }
        graph[0].add(new create_graph.Edge(0, 2));
        graph[0].add(new create_graph.Edge(0, 3));

        graph[1].add(new create_graph.Edge(1, 0));

        graph[2].add(new create_graph.Edge(2, 1));

        graph[3].add(new create_graph.Edge(3, 4));
    }

    public static void topSort(ArrayList<create_graph.Edge>[] graph, int curr, boolean[] vis, Stack<Integer> st) {
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            create_graph.Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topSort(graph, e.dest, vis, st);
            }
        }
        st.push(curr);
    }

    public static void dfs(ArrayList<create_graph.Edge>[] graph, int curr, boolean[] vis){
        // System.out.println("Step 3");
        vis[curr] = true;
        System.out.print(curr+" ");
        for(int i=0;i<graph[curr].size();i++){
            create_graph.Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static void kosaraju(ArrayList<create_graph.Edge> [] graph, int v){

        //step 1 = O(v+E)
        // System.out.println("Step 1");
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[v];

        for(int i=0;i<v;i++){
            if(!vis[i]){
                topSort(graph, i, vis, st);
            }
        }

        //step 2
        ArrayList<create_graph.Edge>[] transpose = new ArrayList[v];
        for(int i=0;i<graph.length;i++){
            vis[i] = false;
            transpose[i] = new ArrayList<create_graph.Edge>();
        }

        for(int i=0;i<v;i++){
            for(int j=0;j<graph[i].size();j++){
                create_graph.Edge e = graph[i].get(j);
                transpose[e.dest].add(new create_graph.Edge(e.dest, e.src));
            }
        }

        while(!st.isEmpty()){
            int curr = st.pop();
            if(!vis[curr]){
                dfs(transpose, curr, vis);
                System.out.println();
            }
        }
    }

    public static void main(String args[]) {
        int v = 5;
        ArrayList<create_graph.Edge> graph[] = new ArrayList[v];
        create_directed_graph(graph);
        kosaraju(graph, v);
    }
}
