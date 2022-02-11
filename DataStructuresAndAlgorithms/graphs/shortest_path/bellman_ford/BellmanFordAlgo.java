import java.util.*;

public class BellmanFordAlgo {

    void bellmanFordAlgo(List<Node> paths, int N, int src) {
        int inf = 1000000;
        int[] dist = new int[N];
        // here don't take Integer.max_value as addition of any
        // +ve int will lead to -ve value
        Arrays.fill(dist, inf);
        dist[src] = 0;

        for (int i = 0; i < N - 1; i++) {
            for (Node n : paths) {
                if (dist[n.u] + n.w < dist[n.v]) {
                    dist[n.v] = dist[n.u] + n.w;
                }
            }
        }

        boolean cycleFound = false;
        for (Node n : paths) {
            if (dist[n.u] + n.w < dist[n.v]) {
                cycleFound = true;
                System.out.println("Cycle found");
                break;
            }
        }
        if (!cycleFound) {
            for (int i = 0; i < N; i++) {
                System.out.println(i + " -> " + dist[i]);
            }
        }
    }

    public static void main(String args[]) {
        int n = 6;
        List<Node> adj = new ArrayList<Node>();

        adj.add(new Node(3, 2, 6));
        adj.add(new Node(5, 3, 1));
        adj.add(new Node(0, 1, 5));
        adj.add(new Node(1, 5, -3));
        adj.add(new Node(1, 2, -2));
        adj.add(new Node(3, 4, -2));
        adj.add(new Node(2, 4, 3));

        BellmanFordAlgo obj = new BellmanFordAlgo();
        obj.bellmanFordAlgo(adj, n, 0);

    }
}

class Node {
    int u, v, w;

    public Node(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}
