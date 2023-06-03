#include <iostream>
#include <vector>
#include <queue>

using namespace std;

typedef pair<int, int> pii;

void addEdge(vector<vector<pii>>& graph, int u, int v, int weight) {
    graph[u].push_back(make_pair(v, weight));
    graph[v].push_back(make_pair(u, weight));
}

void primMST(const vector<vector<pii>>& graph, int startVertex) {
    int V = graph.size();

    priority_queue<pii, vector<pii>, greater<pii>> pq;

    vector<int> key(V, INT_MAX);
    vector<int> parent(V, -1);
    vector<bool> inMST(V, false);

    pq.push(make_pair(0, startVertex));
    key[startVertex] = 0;

    while (!pq.empty()) {
        int u = pq.top().second;
        pq.pop();

        inMST[u] = true;

        for (const auto& neighbor : graph[u]) {
            int v = neighbor.first;
            int weight = neighbor.second;

            if (!inMST[v] && weight < key[v]) {
                key[v] = weight;
                parent[v] = u;
                pq.push(make_pair(key[v], v));
            }
        }
    }

    cout << "Minimum Spanning Tree:" << endl;
    for (int i = 1; i < V; ++i) {
        cout << parent[i] << " - " << i << endl;
    }
}

int main() {
    vector<vector<int>> graph = {
        {0, 3, 0, 0, 0, 1},
        {3, 0, 2, 1, 10, 0},
        {0, 2, 0, 3, 0, 5},
        {0, 1, 3, 0, 5, 0},
        {0, 10, 0, 5, 0, 4},
        {1, 0, 5, 0, 4, 0}
    };

    vector<vector<pii>> graphVector(graph.size());
    for (int i = 0; i < graph.size(); ++i) {
        for (int j = 0; j < graph[i].size(); ++j) {
            if (graph[i][j] != 0) {
                addEdge(graphVector, i, j, graph[i][j]);
            }
        }
    }

    primMST(graphVector, 0);

    return 0;
}
