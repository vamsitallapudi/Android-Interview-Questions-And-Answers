import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUndirectedWeighted {

    // To find shortest path in an Undirected Graph with Unit Weights
    private void shortestPath(ArrayList<ArrayList<Integer>> adj, int V, int src) {
        int[] dist = new Int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(src); // adding source to queue initially to start from here
        dist[src] = 0; // source to source distance is always zero.
        while (!q.isEmpty()) {
            int node = q.poll();

            int childDist = dist[node] + 1;
            for (int j : adj.get(node)) {
                if (childDist < dist[j]) {
                    dist[j] = childDist;
                    // This will be the shortest path. Hence we add to queue to travel through this.
                    q.add(j);
                }
            }
        }
        for (int i : dist) {
            System.out.print(i + " ");
        }
    }
}
