import java.util.*;

public class ShortedDAGWeighted {

    public int[] shortestPath(int V, int src, List<List<Pair<Integer>>> adj) {
        boolean[] visited = new boolean[V];
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topoDFS(i, ans, visited, stack, adj);
            }
        }
        int index = 0;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            // now find shortest path and update dist array
            if (dist[node] != Integer.MAX_VALUE) { // check if node is reached previously
                for (Pair<Integer> it : adj.get(node)) {
                    int currDist = dist[node] + it.second;
                    if (currDist < dist[it.first]) {
                        dist[it.first] = currDist;
                    }
                }
            }

        }
        return dist;
    }

    public void topoDFS(int i, boolean[] visited, Stack<Integer> stack, List<List<Pair<Integer>>> adj) {
        visited[i] = true;
        for (Pair<Integer> p : pairs.get(node)) {
            if (!visited[p.first]) {
                topoDFS(p.first, visited, stack, pairs);
            }
        }
        stack.push(p.first);
    }
}

class Pair<T> {
    T first;
    T second;

    Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }
}
