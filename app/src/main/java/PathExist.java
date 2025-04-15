public class PathExist {
    // This fills the adjacency list with the edges
    for(int i = 0; i < edges.length; i++) {
        int node1 = edges[i][0];
        int node2 = edges[i][1];

        graph.get(node1).add(node2);
        graph.get(node2).add(node1);
    } 
    boolean[] visited = new boolean[n];// This created a boolean array to keep track of nodes that have already been visited
    Queue<Integer> queue = new LinkedList<>(); // This creates a queue for BFS
   
    // This adds th source node to the queue and it marks it as visited
    queue.add(source);
    visited[source] = true;

   // This starts the BFS loop
    while(!queue.isEmpty()) { 
        int curr = queue.poll();

        if(curr == destination) { // If the curr node is the destination, we reutrn true
            return true;
        }
    }
    // Goes through all the neighbors of the curr node
    List<Integer> neighbors = graph.get(curr);
    for(int i = 0; i< neighbors.size(); i++) {
        int neighbor = neighbors.get(i);

        // This is if we have not visited the neighbor yet
        if(!visited[neighbor]) {
            queue.add(neighbor);
            visited[neighbor] = true;
        }
        return false; // If we finish the BFS and we did not find the destination, return false
    }
}
