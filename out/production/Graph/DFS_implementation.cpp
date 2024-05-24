#include <iostream>
using namespace std;
#include <vector>
#include <stack>

int main()
{
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

    stack<int> s;
    int i=0;
    s.push(i);

    while(!s.empty()){
        int currentNode = s.top();
        s.pop();
        if(!visited[currentNode]){
            visited[currentNode] = 1;
            cout<<currentNode<<" ";

            for(int i=nodes-1; i>=0; i--){
                if(matrix[currentNode][i]==1 && !visited[i]){
                    s.push(i);
                }
            }
        }
    }
}