public class ReorderRoutes {
    // This represents a pair of city and direction
    static class Pair {
        int city;
        int direction; // 1 means the original direction from and to, 0 means the reverse direction

        Pair(int city, int direction) {
            this.city = city;
            this.direction = direction;
        }
    }

    public int minReorder(int n, int[][] connections) {
        // This method will create the adjacency list to store the roads
        List<List<Pair>> graph = new ArrayList<>();

        // This initializes the list for each city
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add roads to the adjacency list
        for (int i = 0; i < connections.length; i++) {
            int from = connections[i][0];
            int to = connections[i][1];

            // from, to original direction
            graph.get(from).add(new Pair(to, 1));

            // to, from reverse direction
            graph.get(to).add(new Pair(from, 0));
        }

        // This makes a visited array to track visited cities
        boolean[] visited = new boolean[n];

        // This makes a queue for BFS
        Queue<Integer> queue = new LinkedList<>();

        // This start BFS from city 0
        queue.add(0);
        visited[0] = true;

        int count = 0; // Number of roads that need to be changed

        // This start BFS loop
        while (!queue.isEmpty()) {
            int current = queue.poll();

            // This goes through each neighbor of the current city
            List<Pair> neighbors = graph.get(current);

            int index = 0;
            while (index < neighbors.size()) {
                Pair neighbor = neighbors.get(index);
                int city = neighbor.city;
                int direction = neighbor.direction;

                if (!visited[city]) {
                    if (direction == 1) {
                        count = count + 1;
                    }
                    visited[city] = true;
                    queue.add(city);
                }

                index = index + 1;
            }
        }

        return count;
    }

    // I added this main method to test the code (Wasn't running, so continue to test)
    public static void main(String[] args) {
        ReorderRoutes obj = new ReorderRoutes();

        int[][] connections = {
            {0, 1},
            {1, 3},
            {2, 3},
            {4, 0},
            {4, 5}
        };

        int result = obj.minReorder(6, connections);

        System.out.println("Minimum roads to change: " + result);
    }
}