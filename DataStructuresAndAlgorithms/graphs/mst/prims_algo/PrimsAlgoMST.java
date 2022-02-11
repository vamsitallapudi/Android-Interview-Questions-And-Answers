import java.util.*;

// Bruteforce approach of Prim's Algorithm to calculate MST for a given graph.
// Time Complexity - O(N)
public class PrimsAlgoMST {

    public void primsAlgoMST(int src, List<List<Node>> adj, int N) {
        boolean mst[] = new boolean[N]; // to indicate that a node is already part of mst or not
        int parent[] = new int[N]; // to store parent of nodes that are part of mst
        int[] dist = new int[N]; // to store distances
        Arrays.fill(dist, Integer.MAX_VALUE); // dist array initialization
        Arrays.fill(parent, -1);// parent array initialization
        // implementing min heap with least dist of a node to come on top
        PriorityQueue<Node> pq = new PriorityQueue<>(N, (a, b) -> a.dist - b.dist);
        pq.add(new Node(src, 0));
        // here N-1 because an MST contains N Nodes => N-1 edges.
        // Its sufficient to iterate through N-1 nodes to get N-1 edges
        for (int i = 0; i < N - 1; i++) {
            // for each iteration, take out the node with min dist from pq and
            // add it to mst
            Node n = pq.poll();
            int minVal = n.val;

            // we extracted our minimum dist. Time to update mst
            mst[minVal] = true;
            // now iterate through the adj nodes of our node with min value.
            for (Node child : adj.get(minVal)) {
                if (!mst[child.val] && child.dist < dist[child.val]) {
                    // add node to pq
                    pq.add(child);
                    // updating dist with adj node's dists
                    dist[child.val] = child.dist;
                    // updating parent array with adj node's parents
                    parent[child.val] = minVal;
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
        s.primsAlgoMST(0, adj, n);
    }
}

class Node {
    Integer val;
    Integer dist;

    Node(int val, int dist) {
        this.val = val;
        this.dist = dist;
    }
}
