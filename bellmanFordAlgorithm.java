import java.util.ArrayList;

public class bellmanFordAlgorithm {
    public static class edge{
        int src;
        int dest;
        int wt;
        public edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<edge>();
        }

        graph[0].add(new edge(0, 1, 2));
        graph[0].add(new edge(0, 2, 4));

        graph[1].add(new edge(1, 2, -4));

        graph[2].add(new edge(2, 3, 2));

        graph[3].add(new edge(3, 4, 4));

        graph[4].add(new edge(4, 1, -1));
    }

    public static void bellmanFord(ArrayList<edge> graph[], int src, int v){
        int dist[] = new int[v];
        for(int i=0;i<v;i++){
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
            else{
                dist[i] = 0;
            }
        }

        //bellman ford logic
        for(int k=0;k<v-1;k++){
            for(int i=0;i<v;i++){
                for(int j=0;j<graph[i].size();j++){
                    edge e = graph[i].get(j);
                    int u=e.src;
                    int d=e.dest;

                    if(dist[u] != Integer.MAX_VALUE && dist[e.src] + e.wt < dist[d]){
                        dist[d] = dist[e.src] + e.wt;
                    }
                }
            }
        }

        //negetive weight cycle
        for(int i=0;i<v;i++){
            for(int j=0;j<graph[i].size();j++){
                edge e = graph[i].get(j);
                int u=e.src;
                int d=e.dest;

                if(dist[u] != Integer.MAX_VALUE && dist[e.src] + e.wt < dist[e.dest]){
                   System.out.println("Negetive weight cycle");
                }
            }
        }

        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i] + " ");
        }
    }

    public static void main(String[] args){
        int v=5;
        ArrayList<edge> graph[] = new ArrayList[v];
        createGraph(graph);

        bellmanFord(graph, 0, v);
    }
}
