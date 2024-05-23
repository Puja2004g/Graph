import java.util.*;
public class DFS_graph{
    public static void dfs(ArrayList<create_graph.Edge> graph[], int curr, boolean vis[]){
        System.out.print(curr+ " ");
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            create_graph.Edge e = graph[curr].get(i);
            if(vis[e.dest] == false){
                dfs(graph, e.dest, vis);
            }
        }
    }
    public static void main(String args[]){
        int V = 7;
        ArrayList<create_graph.Edge> graph[] = new ArrayList[V];
        create_graph.createGraph(graph);
        boolean vis[]= new boolean[V];
        dfs(graph, 0, vis);
    }
}