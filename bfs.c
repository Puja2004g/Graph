#include <stdio.h>
#include <stdlib.h>

struct queue{
    int size;
    int f;
    int r;
    int *arr;
};

int main(){
    struct queue q;
    q.size = 100;
    q.f = q.r = 0;
    q.arr = (int *)malloc(q.size * sizeof(int));

    int u;
    int i=0;
    int visited[7] = {0,0,0,0,0,0,0};
    int a[7][7] =
    {
        {0,1,1,1,0,0,0},
        {1,0,1,0,0,0,0},
        {1,1,0,1,1,0,0},
        {1,0,1,0,1,0,0},
        {0,0,1,1,0,1,1},
        {0,0,0,0,1,0,0},
        {0,0,0,0,1,0,0}
    };

    print("%d", i);
    visited[i] = 1;
    enqueue(&q, i);
    while(!isEmpty(&q)){
        int node = dequeue(&q);
        for(int j=0;j<7;j++){
            printf("%d", j);
            visited[j] = 1;
            enqueue(&q,j);
        }
    }

    return 0;
}
