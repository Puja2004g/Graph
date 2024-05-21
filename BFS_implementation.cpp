#include <iostream>
#include <queue>
#include <vector>
using namespace std;

int main()
{
    queue<int> q;
    vector<vector<int>> matrix = {
        {0, 1, 1, 1, 0, 0, 0},
        {1, 0, 1, 0, 0, 0, 0},
        {1, 1, 0, 1, 1, 0, 0},
        {1, 0, 1, 0, 1, 0, 0},
        {0, 0, 1, 1, 0, 1, 1},
        {0, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 1, 0, 0}};

    int nodes = matrix.size();
    vector<int> visited(nodes, 0);

    int startNode = 0; // Starting node index
    visited[startNode] = 1;
    q.push(startNode);

    while (!q.empty())
    {
        int currentNode = q.front();
        q.pop();

        // Print the current node index
        cout << currentNode << " ";

        for (int j = 0; j < nodes; j++)
        {
            // Only push unvisited neighbors into the queue
            if (!visited[j])
            {
                visited[j] = 1;
                q.push(j);
            }
        }
    }
    cout << endl; // Ensure proper formatting
    return 0;
}
