# Graph


```java

// 2D array
class GraphMatrix {
    private int[][] adjMatrix;
    private int size;

    public GraphMatrix(int size) {
        this.size = size;
        adjMatrix = new int[size][size];
    }

    public void addEdge(int u, int v) {
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1; // For undirected graphs
    }

    public boolean isConnected(int u, int v) {
        return adjMatrix[u][v] == 1;
    }
}

// or 

// array of lists
class GraphList {
    private Map<Integer, List<Integer>> adjList;

    public GraphList() {
        adjList = new HashMap<>();
    }

    public void addEdge(int u, int v) {
        adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(u); // Undirected graph
    }

    public List<Integer> getNeighbors(int node) {
        return adjList.getOrDefault(node, new ArrayList<>());
    }
}

```