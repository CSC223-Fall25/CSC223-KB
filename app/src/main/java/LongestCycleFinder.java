public class LongestCycleFinder {

    public int longestCycle(int[] edges) {
        int n = edges.length;

        // To mark when each node was first visited
        int[] visitTime = new int[n];
        for (int i = 0; i < n; i++) {
            visitTime[i] = -1;
        }

        int step = 0;
        int longest = -1;

        for (int i = 0; i < n; i++) {
            // Only visit a node if it hasn't been visited before
            if (visitTime[i] == -1) {

                int current = i;
                int startStep = step;

                while (current != -1 && visitTime[current] == -1) {
                    visitTime[current] = step;
                    step = step + 1;
                    current = edges[current];
                }

                // If we found a cycle
                if (current != -1 && visitTime[current] >= startStep) {
                    int cycleLength = step - visitTime[current];
                    if (cycleLength > longest) {
                        longest = cycleLength;
                    }
                }
            }
        }

        return longest;
    }
}
