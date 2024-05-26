#include <vector>
#include <iostream>
#include <queue>
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

class Pair
{
public:
    int node;
    int dist;

    Pair(int n, int d)
    {
        this->node = n;
        this->dist = d;
    }

    bool operator>(const Pair &p2) const
    {
        return this->dist > p2.dist; // ascending order
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

        graph[1].push_back(Edge(1, 3, 7));
        graph[1].push_back(Edge(1, 2, 1));

        graph[2].push_back(Edge(2, 4, 3));

        graph[3].push_back(Edge(3, 5, 1));

        graph[4].push_back(Edge(4, 3, 2));
        graph[4].push_back(Edge(4, 5, 5));
    }
    void dijkstra(vector<Edge> graph[], int v, int src)
    {
        vector<int> dist(v, INT_MAX);
        vector<bool> vis(v, false);

        dist[src] = 0;
        priority_queue<Pair, vector<Pair>, greater<Pair>> pq;
        pq.push(Pair(src, 0));

        while (!pq.empty())
        {
            Pair curr = pq.top();
            pq.pop();

            if (!vis[curr.node])
            {
                vis[curr.node] = true;

                for (int i = 0; i < graph[curr.node].size(); i++)
                {
                    Edge e = graph[curr.node][i];
                    int u = e.src;
                    int v = e.dest;
                    if (!vis[v] && dist[v] > dist[curr.node] + e.weight)
                    {
                        dist[v] = dist[curr.node] + e.weight;
                        pq.push(Pair(v, dist[v]));
                    }
                }
            }
        }
        for (int i = 0; i < v; i++)
        {
            cout << dist[i] << " ";
        }
    }
};

int main()
{
    int V = 6;
    vector<Edge> graph[V];
    functions f;
    f.createGraph(graph, V);
    f.dijkstra(graph, V, 0);
    return 0;
}