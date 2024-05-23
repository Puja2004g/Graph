import java.util.ArrayList;

public class cycle_detection_undirected {

     public static void create_undirected_graph(ArrayList<create_graph.Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<create_graph.Edge>();
        }
        graph[0].add(new create_graph.Edge(0,1));
        graph[0].add(new  create_graph.Edge(0,4));

        graph[1].add(new  create_graph.Edge(1,0));
        graph[1].add(new  create_graph.Edge(1,2));
        graph[1].add(new  create_graph.Edge(1,4));

        graph[2].add(new  create_graph.Edge(2,1));
        graph[2].add(new  create_graph.Edge(2,3));

        graph[3].add(new  create_graph.Edge(3,2));

        graph[4].add(new  create_graph.Edge(4,0));
        graph[4].add(new  create_graph.Edge(4,1));
        graph[4].add(new  create_graph.Edge(4,5));

        graph[5].add(new  create_graph.Edge(5,4));
    }

    public static boolean isCycleUndirected(ArrayList<create_graph.Edge> graph[], int curr, boolean vis[], int par) {
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            create_graph.Edge e = graph[curr].get(i);
            if(vis[e.dest] && e.dest != par){
                return true;
            }
            else if(!vis[e.dest]){
                if(isCycleUndirected(graph, e.dest, vis, curr)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<create_graph.Edge> graph[] = new ArrayList[v];
        create_undirected_graph(graph);

        System.out.println(isCycleUndirected(graph, 0,new boolean[v], -1));
    }
}
