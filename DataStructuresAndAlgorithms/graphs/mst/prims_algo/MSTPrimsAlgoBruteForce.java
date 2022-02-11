import java.util.*;

// Bruteforce approach of Prim's Algorithm to calculate MST for a given graph.
// Time Complexity - O(N^2)
public class MSTPrimsAlgoBruteForce {

    public void primsAlgoBruteforce(int src, List<List<Node>> adj, int N) {
        boolean mst[] = new boolean[N];
        int parent[] = new int[N];
        int[] key = new int[N];
        Arrays.fill(key, Integer.MAX_VALUE); // key array initialization
        Arrays.fill(parent, -1);// parent array initialization
        key[src] = 0; // initializing source to 0
        // here N-1 because an MST contains N Nodes => N-1 edges.
        // Its sufficient to iterate through N-1 nodes to get N-1 edges
        for (int i = 0; i < N - 1; i++) {
            int minKey = Integer.MAX_VALUE;
            int minInd = 0;
            for (int k = 0; k < N; k++) { // iterate through keys
                if (!mst[i] && key[i] < minKey) {
                    minKey = key[i];
                    minInd = i;
                }
            }
            // we extracted our minimum key. Time to update mst
            mst[minInd] = true;
            // now iterate through the nodes of our key (minKey)
            for (Node node : adj.get(minInd)) {
                if (!mst[node.val] && node.weight < key[node.val]) {
                    // updating key with adj node's weights
                    key[node.val] = node.weight;
                    // updating parent array with adj node's parents
                    parent[node.val] = minInd;
                }
            }
        }

        for (int i = 1; i < N; i++) {
            System.out.println(parent[i] + " - " + i);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Node>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        adj.get(0).add(new Node(1, 2));
        adj.get(1).add(new Node(0, 2));

        adj.get(1).add(new Node(2, 3));
        adj.get(2).add(new Node(1, 3));

        adj.get(0).add(new Node(3, 6));
        adj.get(3).add(new Node(0, 6));

        adj.get(1).add(new Node(3, 8));
        adj.get(3).add(new Node(1, 8));

        adj.get(1).add(new Node(4, 5));
        adj.get(4).add(new Node(1, 5));

        adj.get(2).add(new Node(4, 7));
        adj.get(4).add(new Node(2, 7));

        MSTPrimsAlgoBruteForce s = new MSTPrimsAlgoBruteForce();
        s.primsAlgoBruteforce(0, adj, n);
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
