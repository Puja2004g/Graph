import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class disconned_graph {
    public static void bfs(ArrayList<create_graph.Edge> graph[], int V, boolean visited[],int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int curr = q.remove();
            if(visited[curr] == false){
                System.out.print(curr + " ");
                visited[curr] = true;

                for(int i=0;i<graph[curr].size();i++){
                   create_graph.Edge e = graph[curr].get(i);
                   q.add(e.dest);
                }
            }
        }
    }

    public static void main(String args[]) {
        int V = 4;
        ArrayList<create_graph.Edge> graph[] = new ArrayList[V];
        create_graph.createGraph(graph);

        boolean vis[] = new boolean[V];
        for(int i=0; i<V;i++){
            if(vis[i] == false){
                bfs(graph, V, vis, i);
            }
        }

        System.out.println();
    }
}
