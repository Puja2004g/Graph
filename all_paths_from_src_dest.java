import java.util.ArrayList;

public class all_paths_from_src_dest {

    public static void printAllPaths(ArrayList<create_graph.Edge> graph[], boolean vis[], int curr, String path,
            int tar) {
                if(curr==tar){
                    System.out.println(path);
                    return;
                }

                for(int i=0;i<graph[curr].size();i++){
                    create_graph.Edge e = graph[curr].get(i);
                    if(vis[e.dest] == false){
                        vis[e.dest] = true;
                        printAllPaths(graph, vis, e.dest, path+"->"+e.dest, tar);
                        vis[e.dest] = false;
                    }
                }
    }

    public static void main(String args[]) {
        int V = 7;
        ArrayList<create_graph.Edge> graph[] = new ArrayList[V];
        create_graph.createGraph(graph);
        int src =0, tar = 5;
        printAllPaths(graph, new boolean[V], src, "0", tar);
    }
}
