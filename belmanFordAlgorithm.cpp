#include <vector>
#include <iostream>
#include <climits>
using namespace std;

class Edge
{
public:
    int src, dest, weight;
    Edge(int src, int dest, int weight)
    {
        this->src = src;
        this->dest = dest;
        this->weight = weight;
    }
};

class functions
{
public:
    void createGraph(vector<Edge> graph[], int v)
    {
        for (int i = 0; i < v; i++)
        {
            graph[i] = vector<Edge>();
        }

        graph[0].push_back(Edge(0, 1, 2));
        graph[0].push_back(Edge(0, 2, 4));

        graph[1].push_back(Edge(1, 2, -4));

        graph[2].push_back(Edge(2, 3, 2));

        graph[3].push_back(Edge(3, 4, 4));

        graph[4].push_back(Edge(4, 1, -1));
    }

    void bellmanFord(vector<Edge> graph[], int v, int src)
    {
        vector<int> dist(v, INT_MAX);
        dist[src] = 0; // Initialize the source distance to 0

        // Relax edges v-1 times
        for (int k = 0; k < v - 1; k++)
        {
            for (int j = 0; j < v; j++)
            {
                for (int i = 0; i < graph[j].size(); i++)
                {
                    Edge e = graph[j][i];
                    int u = e.src;
                    int v = e.dest;

                    if (dist[u] != INT_MAX && dist[v] > dist[u] + e.weight)
                    {
                        dist[v] = dist[u] + e.weight;
                    }
                }
            }
        }

        // Check for negative-weight cycles
        for (int j = 0; j < v; j++)
        {
            for (int i = 0; i < graph[j].size(); i++)
            {
                Edge e = graph[j][i];
                int u = e.src;
                int v = e.dest;

                if (dist[u] != INT_MAX && dist[v] > dist[u] + e.weight)
                {
                    cout << "Graph contains a negative-weight cycle" << endl;
                    return;
                }
            }
        }

        for (int i = 0; i < v; i++)
        {
            if (dist[i] == INT_MAX)
            {
                cout << "INF ";
            }
            else
            {
                cout << dist[i] << " ";
            }
        }
        cout << endl;
    }
};

int main()
{
    int V = 6;
    vector<Edge> graph[V];
    functions f;
    f.createGraph(graph, V);
    f.bellmanFord(graph, V, 0);

    return 0;
}