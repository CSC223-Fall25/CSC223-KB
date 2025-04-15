public class LongestCycle {
    public int longestCycle(int[] edges) {
        int n = edges.length;

        // This array should keep track if we have completely visited a node
        boolean[] visited = new boolean[n];

        int longest = -1;

        // This goes through every node
        for (int i = 0; i < n; i++) {
            // This should tell us if the node was already visited, and if so it will skip it
            if (visited[i]) {
                continue;
            }

            // This map should track the current path and its index
            int[] timeVisited = new int[n];
            for (int j = 0; j < n; j++) {
                timeVisited[j] = -1;
            }

            int current = i;
            int time = 0;
}
