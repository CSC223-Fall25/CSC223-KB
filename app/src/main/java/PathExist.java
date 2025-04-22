public class PathExist {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[][] graph = new boolean[n][n];

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            // connecting both directions
            graph[u][v] = true;
            graph[v][u] = true;
        }

        // array to track which nodes we've already checked
        boolean[] visited = new boolean[n];

        // Start DFS from the source node
        return DFS(source, destination, graph, visited);
    }

    public boolean DFS(int current, int destination, boolean[][] graph, boolean[] visited) {
        // If we reach the destination, return true
        if (current == destination) {
            return true;
        }

        // Mark the current node as visited
        visited[current] = true;

        // Try all possible neighbors
        for (int i = 0; i < graph.length; i++) {
            
            // Check if there's a connection and the neighbor hasn't been visited
            if (graph[current][i] && !visited[i]) {

                boolean found = DFS(i, destination, graph, visited);
               
                if (found) {
                    return true;
                }
            }
        }

        return false;
    }
}
