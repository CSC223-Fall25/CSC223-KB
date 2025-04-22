import java.util.*;

public class CityRoadReorder {

    public int minReorder(int n, int[][] connections) {

        List<List<Integer>> neighbors = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            neighbors.add(new ArrayList<>());
        }

        boolean[][] originalDirection = new boolean[n][n];

        for (int i = 0; i < connections.length; i++) {
            int from = connections[i][0];
            int to = connections[i][1];

            // Add both cities to each other's neighbor list
            neighbors.get(from).add(to);
            neighbors.get(to).add(from);

            // Mark that the road was originally from -> to
            originalDirection[from][to] = true;
        }

        // Array to track visited cities
        boolean[] visited = new boolean[n];

        // Start from city 0
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        int changesNeeded = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            List<Integer> currentNeighbors = neighbors.get(current);

            for (int next : currentNeighbors) {
                if (!visited[next]) {

                    // If the road is going away from city 0, we need to change it
                    if (originalDirection[current][next]) {
                        changesNeeded = changesNeeded + 1;
                    }

                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        return changesNeeded;
    }
}
