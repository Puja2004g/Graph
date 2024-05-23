import java.util.ArrayList;

public class cycle_detection_directed {

    public static void create_directed_graph(ArrayList<create_graph.Edge>[] graph){
        for(int i =0;i<graph.length;i++){
            graph[i] = new ArrayList<create_graph.Edge>();
        }
        graph[0].add(new create_graph.Edge(0, 2));
        graph[1].add(new create_graph.Edge(1, 0));
        graph[2].add(new create_graph.Edge(2, 3));
        graph[3].add(new create_graph.Edge(3, 0));
    }

    public static boolean isCycleDetected(ArrayList<create_graph.Edge>[] graph, boolean[] vis, int curr, boolean rec[]){
        vis[curr] = true;
        rec[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            create_graph.Edge e = graph[curr].get(i);

            if(rec[e.dest]==true){
                return true;
            }
            else if(!vis[e.dest]){
                if(isCycleDetected(graph, vis, e.dest, rec)){
                    return true;
                }
            }
        }
        rec[curr]=false;
        return false;
    }
    public static void main(String args[]){
        int v = 4;
        ArrayList<create_graph.Edge> graph[] = new ArrayList[v];
        create_directed_graph(graph);

        boolean vis[] = new boolean[v];
        boolean rec[] = new boolean[v];

        for(int i=0;i<v;i++){
            if(!vis[i]){
                boolean isCycle = isCycleDetected(graph, vis, 0, rec);
                if(isCycle){
                    System.out.println(isCycle);
                    break;
                }
            }
        }
    }
}