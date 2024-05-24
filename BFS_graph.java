import java.util.*;

public class BFS_graph {
    public static void bfs(ArrayList<create_graph.Edge> graph[], int V){
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[V];

        q.add(0);

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
        int V = 7;
        ArrayList<create_graph.Edge> graph[] = new ArrayList[V];
        create_graph.createGraph(graph);
        bfs(graph, V);
    }
}
