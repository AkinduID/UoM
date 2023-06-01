#include<iostream>
#include<stdio.h>
using namespace std;
#define INFINITY 9999;

void dijkstra(int graph[6][6],int n, int start){
    int cost[6][6],dist[6],pred[6];
    int visited[6],count,mindist,nextnode,i,j;
    //pred[] stores the predecessor of each node
    //count gives the number of nodes seen so far
    //create the cost matrix
    for(i=0;i<n;i++)
        for(j=0;j<n;j++)
            if(graph[i][j]==0){
                cost[i][j]=INFINITY;}
            else{
                cost[i][j]=graph[i][j];}
    //initialize pred[],dist[] and visited[]
    for(i=0;i<n;i++){
        dist[i]=cost[start][i];
        pred[i]=start;
        visited[i]=0;
    }
    dist[start]=0;
    visited[start]=1;
    count=1;
    while(count<n-1){
        mindist=INFINITY;
        //nextnode gives the node at minimum distance
        for(i=0;i<n;i++)
            if(dist[i]<mindist&&!visited[i]){
                mindist=dist[i];
                nextnode=i;
            }
        //check if a better path exists through nextnode
        visited[nextnode]=1;
        for(i=0;i<n;i++)
            if(!visited[i])
                if(mindist+cost[nextnode][i]<dist[i]){
                    dist[i]=mindist+cost[nextnode][i];
                    pred[i]=nextnode;
                }
        count++;
    }
    //print the path and distance of each node
    cout<<"\nDistance From Node "<<start;
    float sum=0.0;
    float avg=0;
    for(i=0;i<n;i++){
        if(i!=start){
            cout<<"\nto "<<i<<" = "<<dist[i];
            sum=sum+dist[i];
        }
    }
    avg = sum/5.0;
    cout<<"\tavg="<<avg<<endl;
}

int graph[6][6] = {
    {0, 10, 0, 0, 15, 5},
    {10, 0, 10, 30, 0, 0},
    {0, 10, 0, 12, 5, 0},
    {0, 30, 12, 0, 0, 20},
    {15, 0, 5, 0, 0, 0},
    {5, 0, 0, 20, 0, 0}
};

int main(){
    int n=6;
    int start=0;
    for(int i=0;i<6;i++){
        dijkstra(graph,n,i);
    }
    
    return 0;
}