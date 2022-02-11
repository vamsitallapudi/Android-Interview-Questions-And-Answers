import java.util.*;

// Dijkstra Algorithm to calculate shortest path in an undirected weighted graph
public class ShortestPathDijkstra {
    public void shortestPath(int src, List<List<Node>> adj, int V) {
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        // default is min heap in java
        PriorityQueue<Node> pq = new PriorityQueue<>(V, (a, b) -> a.weight - b.weight);
        pq.add(new Node(src, 0)); // since src dist is always 0.

        while (!pq.isEmpty()) {
            Node n = pq.poll();
            for (Node it : adj.get(n.val)) {
                int currDist = dist[n.val] + it.weight;
                if (currDist < dist[it.val]) {
                    dist[it.val] = currDist;
                    pq.add(new Node(it.val, dist[it.val]));
                }
            }
        }

        for (int i : dist) {
            System.out.print(i + " ");
        }

    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Node>> adj = new ArrayList<List<Node>>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new Node(1, 2));
        adj.get(1).add(new Node(0, 2));

        adj.get(1).add(new Node(2, 4));
        adj.get(2).add(new Node(1, 4));

        adj.get(0).add(new Node(3, 1));
        adj.get(3).add(new Node(0, 1));

        adj.get(3).add(new Node(2, 3));
        adj.get(2).add(new Node(3, 3));

        adj.get(1).add(new Node(4, 5));
        adj.get(4).add(new Node(1, 5));

        adj.get(2).add(new Node(4, 1));
        adj.get(4).add(new Node(2, 1));

        ShortestPathDijkstra s = new ShortestPathDijkstra();
        s.shortestPath(0, adj, V);
    }
}

class Node {
    Integer val;
    Integer weight;

    Node(int val, int weight) {
        this.val = val;
        this.weight = weight;
    }
}
